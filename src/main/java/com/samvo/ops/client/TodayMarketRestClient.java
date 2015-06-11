package com.samvo.ops.client;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.samvo.ops.client.model.feed.Matches;

/**
 * @author Phil
 * 4 Jun 2015
 * Description - Today Market Feed Rest Client.
 */
@Component("todayMarketRestClient")
public class TodayMarketRestClient extends AbstractMarketRestClient implements MarketRestClient {

	/**
	 * Today market URL.
	 */
	private static final String TD_URL = "https://%s/OPS/TDData?sessiontoken=%s";
	
	/**
	 * Today market URL with match Id parameter.
	 */
	private static final String TD_BY_MATCH_IDS_URL = "https://%s/OPS/TDData?sessiontoken=%s&matchId=%s";
	
	@Override
	public Matches getMarketFeedData(String sessionToken) {
		return restTemplate.getForObject(String.format(TD_URL, host, sessionToken), Matches.class);
	}

	@Override
	public Matches getMarketFeedData(String sessionToken, Set<String> matchIds) {
		return restTemplate.getForObject(String.format(TD_BY_MATCH_IDS_URL, host, sessionToken, toDelimitedStrings(matchIds)), Matches.class);
	}

	@Override
	public String getMarketFeedDataXml(String sessionToken) {
		return StringUtils.EMPTY;
	}

	@Override
	public String getMarketFeedDataXml(String sessionToken, Set<String> matchIds) {
		return StringUtils.EMPTY;
	}
}
