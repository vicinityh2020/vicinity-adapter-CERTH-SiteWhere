package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class WorkflowClass {
	// variables
	private Variable aid = new Variable("aid", "", "String");
	private Variable oid = new Variable("oid", "", "String");
	private Variable topic = new Variable("topic", "", "String");
	private Variable param_value = new Variable("value", "", "String");
	private Variable username = new Variable("username", "", "String");
	private Variable password = new Variable("password", "", "String");
	private SiteWhereAdapterResponse SiteWhereAdapter_response = new SiteWhereAdapterResponse();
	private SiteWhereAdapterRequest SiteWhereAdapter_request = new SiteWhereAdapterRequest();

	public static class Input {

		private String parameterName;
		private String parameterValue;
		
		public Input() {
			
		}
		
		public Input(String parameterName, String parameterValue) {
			this.parameterName = parameterName;
			this.parameterValue = parameterValue;
		}

		@XmlElement(name = "parameterName")
		public String getparameterName() {
			return parameterName;
		}

		public void setparameterName(String parameterName) {
			this.parameterName = parameterName;
		}

		@XmlElement (name = "parameterValue")
		public String getparameterValue() {
			return parameterValue;
		}

		public void setparameterValue(String parameterValue) {
			this.parameterValue = parameterValue;
		}

	}

	@XmlRootElement
	public static class SiteWhereAdapterRequest {

		private ArrayList<Input> input = new ArrayList<Input>();

		public SiteWhereAdapterRequest(ArrayList<Input> input) {
			this.input = input;
		}

		public SiteWhereAdapterRequest() {
			// TODO Auto-generated constructor stub
		}

		@XmlElement(name = "input")
		public ArrayList<Input> getinput() {
			return input;
		}

		public void setinput(ArrayList<Input> input) {
			this.input = input;
		}

	}

	public static class SiteWhereAdapterResponse {
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
	public static class Response {
		private String message;

		public Response() {
		}

		public Response(String message) {
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

	public static class Variable {
		public String name;
		public String value;
		public String type;
		public ArrayList<Variable> subtypes = new ArrayList<Variable>();
		public ArrayList<Variable> arrayElements = new ArrayList<Variable>();

		Variable(String name, String value, String type) {
			this.name = name;
			this.value = value;
			this.type = type;
		}

		Variable(Variable prototype) {
			this.name = prototype.name;
			this.value = prototype.value;
			this.type = prototype.type;
			for (Variable sub : prototype.subtypes) {
				Variable arg = new Variable(sub);
				subtypes.add(arg);
			}
			for (Variable el : prototype.arrayElements) {
				Variable arg = new Variable(el);
				arrayElements.add(arg);
			}
		}

		public Variable getSubtype(String name) {
			for (Variable sub : subtypes) {
				if (sub.name.equals(name.replaceAll("[^A-Za-z]", ""))) {
					return sub;
				}
			}
			return null;
		}
	}

	protected String callStartNode() throws Exception {
		return "callSiteWhereAdapter";
	}

	protected String callEndNode() throws Exception {
		return null;
	}

	protected String callSiteWhereAdapter() throws Exception {
		// call service: SiteWhereAdapter
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "https://***/sitewhere/api/mqtt/publish?protocol=tcp&url=smarthome.iti.gr&port=1883&topic=/{topic}/{oid}/control&message={oid}|{value}";
		wsUrl = wsUrl.replace("{value}", param_value.value);
		wsUrl = wsUrl.replace("{oid}", oid.value);
		wsUrl = wsUrl.replace("{topic}", topic.value);
		String crudVerb = "GET";
		boolean hasAuth = true;
		String auth = username.value + ":" + password.value;
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SiteWhereAdapter_response = gson.fromJson(result, SiteWhereAdapterResponse.class);
		return "callEndNode";
	}

	public String call(String name) throws Exception {
		if (name.equals("callStartNode"))
			return callStartNode();
		if (name.equals("callEndNode"))
			return callEndNode();
		if (name.equals("callSiteWhereAdapter"))
			return callSiteWhereAdapter();
		return null;
	}

	public Response parseResponse(String aid, String oid, SiteWhereAdapterRequest request) throws Exception {
		// assign inputs to variables

		this.username.value = "*";
		this.password.value = "*";
		String splitOid[] = null;
		if (oid != null && oid.contains(":")) {
			splitOid = oid.split(":");
		}
		

		// assign uri parameters to variables
		if (aid == null) {
			this.aid.value = "";
		} else {
			this.aid.value = aid;
		}
		if (oid == null) {
			this.oid.value = "";
		} else if (!oid.contains(":")){
			this.oid.value = oid;
		} else {
			this.oid.value = splitOid[1];
		}
		if (oid == null || (!oid.contains(":"))) {
			this.topic.value = "";
		} else {
			this.topic.value = splitOid[0];
		}
		
		
		SiteWhereAdapter_request = new SiteWhereAdapterRequest(request.getinput());
		if (SiteWhereAdapter_request.getinput() != null && !SiteWhereAdapter_request.getinput().isEmpty() && SiteWhereAdapter_request.getinput().get(0).getparameterValue() != null){
			if (topic.value.equals("plugwise")){
				this.param_value.value = SiteWhereAdapter_request.getinput().get(0).getparameterValue();
			} else if (topic.value.equals("hvacs")){
				this.param_value.value = this.aid.value + "|";
				if (SiteWhereAdapter_request.getinput().get(0).getparameterValue().equals("On")){
					this.param_value.value += "1" ;
				} else if (SiteWhereAdapter_request.getinput().get(0).getparameterValue().equals("Off")){
					this.param_value.value += "0" ;
				}
			}
			
		} else {
			return new Response("Input is not valid");
		}
		
		
		String _nextCall = "callSiteWhereAdapter";
		while (_nextCall != null) {
			_nextCall = call(_nextCall);

		}
		// create class instance to be returned
		Response response = new Response();
		if (SiteWhereAdapter_response.getmessage() != null){
		 response = new Response(SiteWhereAdapter_response.getmessage());
		}else{
			response = new Response("error");
		}
		return response;
	}
}