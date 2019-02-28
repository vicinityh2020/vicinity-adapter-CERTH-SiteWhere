package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adapter.services.WorkflowClass.Variable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class WorkflowClass2 {
	// variables
	private Variable measuredParameter = new Variable("measuredParameter", "", "String");
	private Variable oid = new Variable("oid", "", "String");
	private Variable tenantAuthToken = new Variable("tenantAuthToken", "", "String");
	private Variable page = new Variable("page", "", "String");
	private Variable pageSize = new Variable("pageSize", "", "String");
	private Variable startDate = new Variable("startDate", "", "String");
	private Variable endDate = new Variable("endDate", "", "String");
	private Variable username = new Variable("username", "", "String");
	private Variable password = new Variable("password", "", "String");
	private SiteWhereAdapterSensorsResponse SiteWhereAdapterSensors_response = new SiteWhereAdapterSensorsResponse();
	private Integer eventSum = 0;

	public static class SiteWhereAdapterSensorsRequest {

		public SiteWhereAdapterSensorsRequest() {
		}

	}

	public static class SiteWhereAdapterSensorsResponse {
		private double humidity;
		private String timestamp;
		private double temperature;
		private double consumption;
		private int status;
		private double setTemp;
		private int userControl;
		private double tempAct;
		private double dimming;
		private double luminance;
		private double co2;
		
		private ArrayList<Event> event = new ArrayList<Event>();

		public void sethumidity(double humidity) {
			this.humidity = humidity;
		}

		@XmlElement
		public double gethumidity() {
			return humidity;
		}

		public void settimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		@XmlElement
		public String gettimestamp() {
			return timestamp;
		}

		public void settemperature(double temperature) {
			this.temperature = temperature;
		}

		@XmlElement
		public double gettemperature() {
			return temperature;
		}

		@XmlElement
		public ArrayList<Event> getevent() {
			return event;
		}

		public void setevent(ArrayList<Event> event) {
			this.event = event;
		}

		@XmlElement
		public double getconsumption() {
			return consumption;
		}

		public void setconsumption(double consumption) {
			this.consumption = consumption;
		}

		@XmlElement
		public int getstatus() {
			return status;
		}

		public void setstatus(int status) {
			this.status = status;
		}

		@XmlElement
		public double getsetTemp() {
			return setTemp;
		}

		public void setsetTemp(double setTemp) {
			this.setTemp = setTemp;
		}

		@XmlElement
		public int getuserControl() {
			return userControl;
		}

		public void setuserControl(int userControl) {
			this.userControl = userControl;
		}

		@XmlElement
		public double gettempAct() {
			return tempAct;
		}

		public void settempAct(double tempAct) {
			this.tempAct = tempAct;
		}

		@XmlElement
		public double getdimming() {
			return dimming;
		}

		public void setdimming(double dimming) {
			this.dimming = dimming;
		}

		@XmlElement
		public double getluminance() {
			return luminance;
		}

		public void setluminance(double luminance) {
			this.luminance = luminance;
		}

		@XmlElement
		public double getco2() {
			return co2;
		}

		public void setco2(double co2) {
			this.co2 = co2;
		}

	}

	public static class Event {
		private String measurementId = "";
		private ArrayList<Entries> entries = new ArrayList<Entries>();

		public Event() {

		}

		public Event(String measurementId, ArrayList<Entries> entries) {
			super();
			this.measurementId = measurementId;
			this.entries = entries;
		}

		@XmlElement
		public String getMeasurementId() {
			return measurementId;
		}

		public void setMeasurementId(String measurementId) {
			this.measurementId = measurementId;
		}

		@XmlElement
		public ArrayList<Entries> getEntries() {
			return entries;
		}

		public void setEntries(ArrayList<Entries> entries) {
			this.entries = entries;
		}
	}

	public static class Entries {
		private int value;
		private String measurementDate = "";

		public Entries() {

		}

		public Entries(int value, String measurementDate) {
			super();
			this.value = value;
			this.measurementDate = measurementDate;
		}

		@XmlElement
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@XmlElement
		public String getMeasurementDate() {
			return measurementDate;
		}

		public void setMeasurementDate(String measurementDate) {
			this.measurementDate = measurementDate;
		}
	}

	@XmlRootElement(name = "Response")
	public static class GetResponse {
		private double value;
		private String timestamp;

		public GetResponse() {
		}

		public GetResponse(double value, String timestamp) {
			this.value = value;
			this.timestamp = timestamp;
		}

		public void setvalue(double value) {
			this.value = value;
		}

		@XmlElement
		public double getvalue() {
			return value;
		}

		public void settimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		@XmlElement
		public String gettimestamp() {
			return timestamp;
		}
	}

	protected String callEndNode() throws Exception {
		return null;
	}

	protected String callSiteWhereAdapterSensors() throws Exception {
		// call service: SiteWhereAdapterSensors
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		inputs.add(measuredParameter);
		inputs.add(tenantAuthToken);
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "https://*/sitewhere/api/assignments/{oid}/measurements/lastValue";
		wsUrl = wsUrl.replace("{oid}", oid.value);
		String crudVerb = "GET";
		boolean hasAuth = true;
		String auth = username.value + ":" + password.value;
		long startTime = System.currentTimeMillis();
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime + "\n");
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SiteWhereAdapterSensors_response = gson.fromJson(result, SiteWhereAdapterSensorsResponse.class);
		return "callEndNode";
	}

	protected String callSiteWhereAdapterCounters() throws Exception {
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		inputs.add(page);
		inputs.add(pageSize);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDateTime = now.format(formatterDate);
		startDate.value = formatDateTime + "T00:00:00.000+0300";

		now = LocalDateTime.now();
		endDate.value = now + "+0300";

		inputs.add(startDate);
		inputs.add(endDate);
		inputs.add(tenantAuthToken);
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "https://*/sitewhere/api/assignments/{oid}/measurements/series";
		wsUrl = wsUrl.replace("{oid}", oid.value);
		String crudVerb = "GET";
		boolean hasAuth = true;
		String auth = username.value + ":" + password.value;
		long startTime = System.currentTimeMillis();
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime + "\n");
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SiteWhereAdapterSensors_response = gson.fromJson(result, SiteWhereAdapterSensorsResponse.class);
		if (!SiteWhereAdapterSensors_response.getevent().isEmpty()) {
			ArrayList<Entries> entries = SiteWhereAdapterSensors_response.getevent().get(0).getEntries();

			for (Entries entry : entries) {
				eventSum += entry.getValue();
			}
		}

		return "callEndNode";

	}

	protected String callStartNode() throws Exception {
		return "callSiteWhereAdapterSensors";
	}

	public String call(String name) throws Exception {
		if (name.equals("callEndNode"))
			return callEndNode();
		if (name.equals("callSiteWhereAdapterSensors"))
			return callSiteWhereAdapterSensors();
		if (name.equals("callSiteWhereAdapterCounters"))
			return callSiteWhereAdapterCounters();
		if (name.equals("callStartNode"))
			return callStartNode();
		return null;
	}

	public GetResponse parseResponse(String pid, String oid) throws Exception {
		// assign inputs to variables
		if (measuredParameter == null) {
			this.measuredParameter.value = "";
		} else {
			this.measuredParameter.value = pid;
		}

		this.tenantAuthToken.value = "*";
		this.page.value = "1";
		this.pageSize.value = "2000";
		this.username.value = "*";
		this.password.value = "*";

		// assign uri parameters to variables
		if (oid == null) {
			this.oid.value = "";
		} else {
			this.oid.value = oid;
		}

		String _nextCall = "callSiteWhereAdapterSensors";
		if (pid.equals("event")) {
			_nextCall = "callSiteWhereAdapterCounters";
		}
		while (_nextCall != null) {

			_nextCall = call(_nextCall);

		}
		double responseValue = 0.0;
		if (pid.equals("temperature")) {
			responseValue = SiteWhereAdapterSensors_response.gettemperature();
		} else if (pid.equals("humidity")) {
			responseValue = SiteWhereAdapterSensors_response.gethumidity();
		} else if (pid.equals("event")) {
			responseValue = eventSum;
		} else if (pid.equals("consumption")) {
			responseValue = SiteWhereAdapterSensors_response.getconsumption();
		} else if (pid.equals("status")) {
			responseValue = (double) SiteWhereAdapterSensors_response.getstatus();
		} else if (pid.equals("setTemp")) {
			responseValue = SiteWhereAdapterSensors_response.getsetTemp();
		} else if (pid.equals("userControl")) {
			responseValue = (double) SiteWhereAdapterSensors_response.getuserControl();
		} else if (pid.equals("tempAct")) {
			responseValue = SiteWhereAdapterSensors_response.gettempAct();
		} else if (pid.equals("dimming")) {
			responseValue = SiteWhereAdapterSensors_response.getdimming();
		} else if (pid.equals("luminance")) {
			responseValue = SiteWhereAdapterSensors_response.getluminance();
		} else if (pid.equals("co2")) {
			responseValue = SiteWhereAdapterSensors_response.getco2();
		} else {
			responseValue = (double) 404;
		}

		String timestamp = "";
		if (pid.equals("event")) {
			if (!SiteWhereAdapterSensors_response.getevent().isEmpty()) {
				int size = SiteWhereAdapterSensors_response.getevent().get(0).getEntries().size();
				timestamp = SiteWhereAdapterSensors_response.getevent().get(0).getEntries().get(size - 1)
						.getMeasurementDate();
			}
		} else {
			timestamp = SiteWhereAdapterSensors_response.gettimestamp();
		}

		// create class instance to be returned
		GetResponse response = new GetResponse(responseValue, timestamp);
		return response;
	}
}