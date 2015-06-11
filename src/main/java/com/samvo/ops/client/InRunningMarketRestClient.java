package com.samvo.ops.client;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.samvo.ops.client.model.feed.Matches;

/**
 * @author Phil
 * 4 Jun 2015
 * Description - In running Market Feed Rest Client.
 */
@Component("inRunningMarketRestClient")
public class InRunningMarketRestClient extends AbstractMarketRestClient implements MarketRestClient {

	/**
	 * In-running URL.
	 */
	private static final String IR_URL = "https://%s/OPS/IRData?sessiontoken=%s";
	
	/**
	 * In running URL by match ids.
	 */
	private static final String IR_BY_MATCH_IDS_URL = "https://%s/OPS/IRData?sessiontoken=%s&matchId=%s";
	
	@Override
	public Matches getMarketFeedData(String sessionToken) {
		return restTemplate.getForObject(String.format(IR_URL, host, sessionToken), Matches.class);
	}

	@Override
	public Matches getMarketFeedData(String sessionToken, Set<String> matchIds) {
		return restTemplate.getForObject(String.format(IR_BY_MATCH_IDS_URL, host, sessionToken, toDelimitedStrings(matchIds)), Matches.class);
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
