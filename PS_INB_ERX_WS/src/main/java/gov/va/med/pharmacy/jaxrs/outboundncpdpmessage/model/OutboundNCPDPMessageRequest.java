package gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class represents outbound message request.
 *
 */
@JsonIgnoreProperties({""})
public class OutboundNCPDPMessageRequest {

	
	private Long outboundNcpdpMsgId;

	public Long getOutboundNcpdpMsgId() {
		return outboundNcpdpMsgId;
	}

	public void setOutboundNcpdpMsgId(Long outboundNcpdpMsgId) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
	}
	
	
	
}
