package com.samvo.ops.client.model.feed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;

import com.samvo.ops.client.model.BaseModel;

/**
 * @author Phil
 * 2 Jun 2015
 * Description - Model for a set of matches.
 * 
 */
@XmlRootElement(name="matches")
@XmlAccessorType(XmlAccessType.FIELD)
public class Matches extends BaseModel {

	/**
	 * Feed last update date.
	 */
	@XmlAttribute(name="lastupdate")
	private long lastUpdated;

	/**
	 * List of matches in the feed
	 */
	@XmlElement(name="match")
	private List<Match> matches = new ArrayList<Match>();
	
	/**
	 * 
	 */
	public Matches() {
		
	}
	
	/**
	 * @return the lastUpdated
	 */
	public long getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * 
	 * @return List<Match>
	 */
	public List<Match> getMatches() {
		return matches;
	}

	/**
	 * 
	 * @param matches
	 */
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}	
	
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Matches.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
        File file = new File("C:\\Users\\Phil\\projects\\samvo-ops-client\\src\\main\\resources\\EMData.xml");
        Matches matches = (Matches)unmarshaller.unmarshal(file);
              
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(matches, new File("EMDataResult.xml"));       
	}
}
