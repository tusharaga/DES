package com.emob.des.scheduler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import com.emob.des.rest.model.IntegrationLog;
import com.emob.des.rest.model.IntegrationLogDetail;
import com.emob.des.rest.service.DesRepository;

public class DesJobScheduler implements Job {
	private DesRepository desRepository;

	public DesJobScheduler() {
		System.out.println("DesJobScheduler intialized ..");
	}

	public void init() {
		System.out.println("DesJobScheduler : DesRepository initialzed..");
		try {
			JobDetail job = new JobDetail();
			job.setName("DesJobScheduler");
			job.setJobClass(DesJobScheduler.class);
			JobDataMap dataMap = new JobDataMap();
			dataMap.put("repo", desRepository);
			job.setJobDataMap(dataMap);
			//configure the scheduler time
			SimpleTrigger trigger = new SimpleTrigger();
			trigger.setName("DesJobSchedulerTrigger");
			trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
			trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			trigger.setRepeatInterval(50000);

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public DesRepository getDesRepository() {
		return desRepository;
	}

	public void setDesRepository(DesRepository desRepository) {
		this.desRepository = desRepository;
	}

	@Override
	public void execute(JobExecutionContext executionContext) throws JobExecutionException {
		desRepository = (DesRepository) executionContext.getJobDetail().getJobDataMap().get("repo");
		List<IntegrationLogDetail> ilds = desRepository.findFailedRequests();
		if(ilds != null && ilds.size() > 0) {
			System.out.println("Found " + ilds.size() + " No. of failed transactions...");
			for (IntegrationLogDetail integrationLogDetail : ilds) {
				// call the webservice here.
				IntegrationLog il = integrationLogDetail.getIntegrationLog();
				String postUrl = il.getUrl();
				postUrl = postUrl.concat("/workFlow/"+il.getWorkflowId()
						+"/event/"+il.getEvent()
						+"/ticketNo/"+il.getTicketId()
						+"/activity/"+il.getActivity());
				String payLoad = integrationLogDetail.getRequestBody();
				HttpClient httpclient = null;
				PostMethod post = new PostMethod(postUrl);
				post.addRequestHeader("Accept" , "application/xml");
				try {
					RequestEntity entity = new StringRequestEntity(payLoad, "application/xml", "utf-8");
					post.setRequestEntity(entity);
					httpclient = new HttpClient();
					httpclient.executeMethod(post);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					post.releaseConnection();
				}
			}
		} else {
			System.out.println("No failed transactions found to reprocess... ");
		}
	}
}
