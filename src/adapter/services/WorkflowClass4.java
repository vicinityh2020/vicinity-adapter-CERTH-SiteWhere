package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adapter.services.WorkflowClass.Variable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonNode;

import org.codehaus.jackson.JsonProcessingException;

import org.codehaus.jackson.map.ObjectMapper;

public class WorkflowClass4 {
	// variables
	private Variable tenantAuthToken = new Variable("tenantAuthToken", "", "String");
	private Variable site = new Variable("site", "", "String");
	private Variable includeSpecification = new Variable("includeSpecification", "", "String");
	private Variable username = new Variable("username", "", "String");
	private Variable password = new Variable("password", "", "String");
	private SiteWhereGETObjectsResponse SiteWhereGETObjects_response = new SiteWhereGETObjectsResponse();
	private Map<String, String> deviceTypes = new HashMap<String, String>();
	private Map<String, String> deviceProperties = new HashMap<String, String>();

	public static class Results {
		private String hardwareId;
		private Specification specification = new Specification();
		private String assignmentToken;

		Results() {
		}

		Results(String hardwareId, Specification specification, String assignmentToken) {
			this.hardwareId = hardwareId;
			this.specification = specification;
			this.assignmentToken = assignmentToken;
		}

		public void sethardwareId(String hardwareId) {
			this.hardwareId = hardwareId;
		}

		@XmlElement
		public String gethardwareId() {
			return hardwareId;
		}

		public void setspecification(Specification specification) {
			this.specification = specification;
		}

		@XmlElement
		public Specification getspecification() {
			return specification;
		}

		public void setassignmentToken(String assignmentToken) {
			this.assignmentToken = assignmentToken;
		}

		@XmlElement
		public String getassignmentToken() {
			return assignmentToken;
		}
	}

	public static class Specification {
		private Metadata metadata = new Metadata();
		private String name = "";
		private String token = "";

		Specification() {
		}

		Specification(Metadata metadata, String name) {
			this.metadata = metadata;
			this.name = name;
		}

		public void setmetadata(Metadata metadata) {
			this.metadata = metadata;
		}

		@XmlElement
		public Metadata getmetadata() {
			return metadata;
		}

		public void setname(String name) {
			this.name = name;
		}

		@XmlElement
		public String getname() {
			return name;
		}

		@XmlElement
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}

	public static class Metadata {
		private String specs;

		Metadata() {
		}

		Metadata(String specs) {
			this.specs = specs;
		}

		public void setspecs(String specs) {
			this.specs = specs;
		}

		@XmlElement
		public String getspecs() {
			return specs;
		}
	}

	public static class SiteWhereGETObjectsResponse {
		private ArrayList<Results> results = new ArrayList<Results>();
		private long numResults;

		public void setresults(ArrayList<Results> results) {
			this.results = results;
		}

		@XmlElement
		public ArrayList<Results> getresults() {
			return results;
		}

		public void setnumResults(long numResults) {
			this.numResults = numResults;
		}

		@XmlElement
		public long getnumResults() {
			return numResults;
		}
	}

	public static class Action {

		private String aid;
		private String affects;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();
		private Input input;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Action() {
		}

		/**
		 * 
		 * @param input
		 * @param affects
		 * @param links
		 * @param aid
		 */
		Action(String aid, String affects, ArrayList<Link> read_links, ArrayList<Link> write_links, Input input) {
			super();
			this.aid = aid;
			this.affects = affects;
			this.read_links = read_links;
			this.write_links = write_links;
			this.input = input;
		}

		@XmlElement
		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		@XmlElement
		public String getAffects() {
			return affects;
		}

		public void setAffects(String affects) {
			this.affects = affects;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

		@XmlElement
		public Input getInput() {
			return input;
		}

		public void setInput(Input input) {
			this.input = input;
		}

	}

	public static class Input {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Input() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Input(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Link {

		private String href;
		private String mediaType;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Link() {
		}

		/**
		 * 
		 * @param href
		 * @param mediaType
		 */
		Link(String href, String mediaType) {
			super();
			this.href = href;
			this.mediaType = mediaType;
		}

		@XmlElement
		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		@XmlElement
		public String getMediaType() {
			return mediaType;
		}

		public void setMediaType(String mediaType) {
			this.mediaType = mediaType;
		}

	}

	public static class Output {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Output() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Output(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Property {

		private String pid;
		private String monitors;
		private Output output;
		private Boolean writable;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Property() {
		}

		/**
		 * 
		 * @param monitors
		 * @param writable
		 * @param links
		 * @param pid
		 * @param output
		 */
		Property(String pid, String monitors, Output output, Boolean writable, ArrayList<Link> read_links,
				ArrayList<Link> write_links) {
			super();
			this.pid = pid;
			this.monitors = monitors;
			this.output = output;
			this.writable = writable;
			this.read_links = read_links;
			this.write_links = write_links;
		}

		@XmlElement
		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		@XmlElement
		public String getMonitors() {
			return monitors;
		}

		public void setMonitors(String monitors) {
			this.monitors = monitors;
		}

		@XmlElement
		public Output getOutput() {
			return output;
		}

		public void setOutput(Output output) {
			this.output = output;
		}

		@XmlElement
		public Boolean getWritable() {
			return writable;
		}

		public void setWritable(Boolean writable) {
			this.writable = writable;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

	}

	@XmlRootElement(name = "Response")
	public static class GetObjectsResponse {

		private String type;
		private String oid;
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		public GetObjectsResponse() {
		}

		/**
		 * 
		 * @param oid
		 * @param properties
		 * @param type
		 * @param actions
		 */
		public GetObjectsResponse(String type, String oid, ArrayList<Property> properties, ArrayList<Action> actions) {
			super();
			this.type = type;
			this.oid = oid;
			this.properties = properties;
			this.actions = actions;
		}

		@XmlElement
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@XmlElement
		public String getOid() {
			return oid;
		}

		public void setOid(String oid) {
			this.oid = oid;
		}

		@XmlElement
		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		@XmlElement
		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	public class PropertiesActions {
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		PropertiesActions() {

		}

		PropertiesActions(ArrayList<Property> properties, ArrayList<Action> actions) {
			this.properties = properties;
			this.actions = actions;

		}

		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	protected String callEndNode() throws Exception {
		return null;
	}

	protected String callSiteWhereGETObjects() throws Exception {
		// call service: SiteWhereGETObjects
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		inputs.add(includeSpecification);
		inputs.add(site);
		inputs.add(tenantAuthToken);
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "https://*/sitewhere/api/devices";
		String crudVerb = "GET";
		boolean hasAuth = true;
		String auth = username.value + ":" + password.value;
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SiteWhereGETObjects_response = gson.fromJson(result, SiteWhereGETObjectsResponse.class);
		return "callEndNode";
	}

	public String call(String name) throws Exception {
		if (name.equals("callEndNode"))
			return callEndNode();
		if (name.equals("callSiteWhereGETObjects"))
			return callSiteWhereGETObjects();
		return null;
	}

	public ArrayList<GetObjectsResponse> parseResponse() throws Exception {
		// assign inputs to variables

		this.tenantAuthToken.value = "*";
		this.site.value = "*";

		this.includeSpecification.value = "true";
		this.username.value = "*";
		this.password.value = "*";

		// temporary values
		deviceTypes.put("Plugwise Circle ITI", "PowerMeter:plugwise");
		deviceTypes.put("Plugwise Sense Iti", "Thermometer:");
		deviceTypes.put("Plugwise Stealth ITI", "LightSwitch:plugwise");
		deviceTypes.put("Eltako Dimmer Controller FSG71", "LightSwitch:enOcean");
		deviceTypes.put("People Counter", "PeopleCounter:");
		deviceTypes.put("LG HVAC", "HVACSensor:hvacs");
		deviceTypes.put("WCTM", "PowerMeter:");
		deviceTypes.put("WHSM", "PowerMeter:");
		deviceTypes.put("Gavazzi Energy Meter 271", "PowerMeter:");
		deviceTypes.put("Eltako Indoor Brightness FIH65B", "LuminanceMeter:");
		deviceTypes.put("Thermokon CO2 Temperature SR04", "CO2Sensor:");
		

		// temporary values
		deviceProperties.put("consumption", "MeanPowerConsumption:false");
		deviceProperties.put("status", "OnOff:true:UCtrlOnOff");
		deviceProperties.put("humidity", "RelativeHumidity:false");
		deviceProperties.put("temperature", "AmbientTemperature:false");
		deviceProperties.put("event", "EntryExit:false");
		deviceProperties.put("setTemp", "AmbientTemperature:true:UControlTempSetPoint");
		deviceProperties.put("tempAct", "AmbientTemperature:false");// should be
																	// different
																	// from the
																	// above
		deviceProperties.put("userControl", "Mode:false");
		deviceProperties.put("dimming", "DimmingLevel:true:");
		deviceProperties.put("co2", "CO2Concentration:false:");
		deviceProperties.put("luminance", "Luminance:false:");

		String _nextCall = "callSiteWhereGETObjects";
		while (_nextCall != null) {
			_nextCall = call(_nextCall);

		}
		// create class instance to be returned
		ArrayList<GetObjectsResponse> response = new ArrayList<GetObjectsResponse>();
		if (SiteWhereGETObjects_response != null) {
			for (Results result : SiteWhereGETObjects_response.getresults()) {
				if (result.getspecification().getname().equals("WCTM")
						|| result.getspecification().getname().equals("WHSM")
						|| result.getspecification().getname().equals("Gavazzi Energy Meter 271")|| !deviceTypes.containsKey(result.getspecification().getname()))
					continue;
				response.add(generateObject(result));
			}
		} else {
			response.add(new GetObjectsResponse());
			response.get(0).setType("error");
		}
		return response;
	}

	public GetObjectsResponse generateObject(Results result) {
		GetObjectsResponse vicinityObject = new GetObjectsResponse();
		String topic = "";
		
		if (deviceTypes.get(result.getspecification().getname()).split(":").length > 1) {
			topic = deviceTypes.get(result.getspecification().getname()).split(":")[1] + ":";
		}
		String oid = topic + result.gethardwareId();
		// For People Counters oid is the assignment token
		if (result.getspecification().getname().equals("People Counter") || result.getspecification().getname().equals("Eltako Indoor Brightness FIH65B") || result.getspecification().getname().equals("Thermokon CO2 Temperature SR04")) {
			oid = result.getassignmentToken();

		}
		String type = deviceTypes.get(result.getspecification().getname()).split(":")[0];
		String assignmentToken = result.getassignmentToken();
		PropertiesActions p_a = parse(result.getspecification().getmetadata().getspecs(), assignmentToken);
		vicinityObject = new GetObjectsResponse(type, oid, p_a.getProperties(), p_a.getActions());
		return vicinityObject;

	}

	public PropertiesActions parse(String json, String assignmentToken) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode;
		ArrayList<String> ssnProperty = new ArrayList<String>();
		ArrayList<String> units = new ArrayList<String>();
		PropertiesActions object = new PropertiesActions();
		try {
			rootNode = mapper.readTree(json);
			Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();
			while (fieldsIterator.hasNext()) {

				Map.Entry<String, JsonNode> field = fieldsIterator.next();
				// System.out.println("Key: " + field.getKey() + "\tValue:" +
				// field.getValue());
				ssnProperty.add(field.getKey());
				JsonNode node = field.getValue();
				String unit = node.get("unit").getTextValue();
				if (unit.isEmpty()) {
					unit = "Adimensional";
				}
				units.add(unit);

			}
			// translate ssnProperty to vicinity ssnProperty
			for (int i = 0; i < ssnProperty.size(); i++) {
				String trimmed_prop = ssnProperty.get(i).trim();
				if (trimmed_prop.equals("status")) {
					// create Links
					// get
					String read_link_href = "/objects/" + assignmentToken + "/properties/" + trimmed_prop;
					ArrayList<Link> read_links = new ArrayList<Link>();
					read_links.add(new Link(read_link_href, "application/json"));
					// post
					String write_link_href = "/objects/{oid}/actions/"
							+ deviceProperties.get(trimmed_prop).split(":")[2];
					ArrayList<Link> write_links = new ArrayList<Link>();
					write_links.add(new Link(write_link_href, "application/json"));
					// create a wot:Action
					Action action = new Action(trimmed_prop, deviceProperties.get(trimmed_prop).split(":")[0],
							read_links, write_links, new Input(units.get(i), ""));
					object.getActions().add(action);
				} else {

					// create Links
					ArrayList<Link> write_links = new ArrayList<Link>();
					// get
					String read_link_href = "/objects/" + assignmentToken + "/properties/" + trimmed_prop;
					ArrayList<Link> read_links = new ArrayList<Link>();
					read_links.add(new Link(read_link_href, "application/json"));
					// put
					String write_link_href = "/objects/{oid}/properties/";
					if (deviceProperties.get(trimmed_prop).split(":").length > 2) {
						write_link_href += deviceProperties.get(trimmed_prop).split(":")[2];	
					} else {
						write_link_href += trimmed_prop;
					}
					write_links.add(new Link(write_link_href, "application/json"));
					// create a wot:Property
					boolean writable = Boolean.parseBoolean(deviceProperties.get(trimmed_prop).split(":")[1]);
					Property property = new Property(trimmed_prop, deviceProperties.get(trimmed_prop).split(":")[0],
							new Output(units.get(i), ""), writable, read_links, write_links);
					object.getProperties().add(property);
				}

			}
			return object;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}