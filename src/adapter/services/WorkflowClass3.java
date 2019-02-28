package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import adapter.services.WorkflowClass.Variable;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class WorkflowClass3 {
	// variables
	private Variable oid = new Variable("oid", "", "String");
	private Variable pid = new Variable("pid", "", "String");
	private Variable topic = new Variable("topic", "", "String");
	private Variable param_value = new Variable("value", "", "String");
	private Variable username = new Variable("username", "", "String");
	private Variable password = new Variable("password", "", "String");
	private SiteWhereAdapterPUTResponse SiteWhereAdapterPUT_response = new SiteWhereAdapterPUTResponse();
	private SiteWhereAdapterPUTRequest SiteWhereAdapterPUT_request = new SiteWhereAdapterPUTRequest();

	private boolean isDimming = false;

	@XmlRootElement
	public static class SiteWhereAdapterPUTRequest {
		private String value = "";

		public SiteWhereAdapterPUTRequest() {
		}

		public SiteWhereAdapterPUTRequest(String value) {
			this.value = value;
		}

		@XmlElement(name = "value")
		public String getvalue() {
			return value;
		}

		public void setvalue(String value) {
			this.value = value;
		}

	}

	public static class SiteWhereAdapterPUTResponse {
		private String message;

		public void setmessage(String message) {
			this.message = message;
		}

		@XmlElement
		public String getmessage() {
			return message;
		}
	}

	@XmlRootElement(name = "Response")
	public static class PutResponse {
		private String message;

		public PutResponse() {
		}

		public PutResponse(String message) {
			this.message = message;
		}

		public void setmessage(String message) {
			this.message = message;
		}

		@XmlElement
		public String getmessage() {
			return message;
		}
	}

	protected String callStartNode() throws Exception {
		return "callSiteWhereAdapterPUT";
	}

	protected String callEndNode() throws Exception {
		return null;
	}

	protected String callSiteWhereAdapterPUT() throws Exception {
		// call service: SiteWhereAdapterPUT
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "https://*/sitewhere/api/mqtt/publish?protocol=tcp&url=smarthome.iti.gr&port=1883&";
		if (isDimming) {
			//topic=/enOcean/dimming&message={"deviceId":"01A76895","value":10}
			wsUrl += "topic=/{topic}/{pid}&message={\"deviceId\":\"{oid}\",\"value\":{value}}";
		} else {
			wsUrl += "topic=/{topic}/{oid}/control&message={oid}|{pid}|{value}";
		}
		wsUrl = wsUrl.replace("{pid}", pid.value);
		wsUrl = wsUrl.replace("{topic}", topic.value);
		wsUrl = wsUrl.replace("{oid}", oid.value);
		wsUrl = wsUrl.replace("{value}", param_value.value);
		String crudVerb = "GET";
		boolean hasAuth = true;
		String auth = username.value + ":" + password.value;
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SiteWhereAdapterPUT_response = gson.fromJson(result, SiteWhereAdapterPUTResponse.class);
		return "callEndNode";
	}

	public String call(String name) throws Exception {
		if (name.equals("callStartNode"))
			return callStartNode();
		if (name.equals("callEndNode"))
			return callEndNode();
		if (name.equals("callSiteWhereAdapterPUT"))
			return callSiteWhereAdapterPUT();
		return null;
	}

	public PutResponse parseResponse(String pid, String oid, SiteWhereAdapterPUTRequest request) throws Exception {
		// assign inputs of services to variables

		this.username.value = "*";
		this.password.value = "*";
		String splitOid[] = null;
		if (oid != null && oid.contains(":")) {
			splitOid = oid.split(":");
		}

		// assign uri parameters of services to variables
		if (oid == null) {
			this.oid.value = "";
		} else if (!oid.contains(":")) {
			this.oid.value = oid;
		} else {
			this.oid.value = splitOid[1];
		}
		if (pid == null) {
			this.pid.value = "";
		} else {
			this.pid.value = pid;
		}
		if (oid == null) {
			this.topic.value = "";
		} else if (!oid.contains(":")) {
			this.topic.value = "";
		} else {
			this.topic.value = splitOid[0];
		}

		SiteWhereAdapterPUT_request = new SiteWhereAdapterPUTRequest(request.getvalue());
		this.param_value.value = SiteWhereAdapterPUT_request.getvalue();

		if (pid.equals("dimming")) {
			isDimming = true;
		}
		// assign other variables
		// call services iterately
		String _nextCall = "callSiteWhereAdapterPUT";
		while (_nextCall != null) {
			// update matchedIO variable values
			_nextCall = call(_nextCall);

		}
		// create class instance to be returned
		PutResponse response = new PutResponse();
		if (SiteWhereAdapterPUT_response!= null){
		if (SiteWhereAdapterPUT_response.getmessage() != null) {
			response = new PutResponse(SiteWhereAdapterPUT_response.getmessage());
		} else {
			response = new PutResponse("error");
		}
		}

		return response;
	}
}