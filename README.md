# 1. Infrastructure overview
This is a Vicinity Adapter for CERTH-ITI Smart House Infrastructure.It adapts SiteWhere IoT Platform, which is used for CERTH-ITI Smart House devices, to Vicinity.

# 2. Configuration and deployment
## Build using Maven

In the root folder of the project:

`mvn clean install`

## Deploy on Tomcat 8.5

Copy the SiteWhereAdapter-0.0.1-SNAPSHOT.war file from ./target directory of the project to /webapps directory located on Tomcat server and start Tomcat server
or 
use Manager web application http://host-IP:port/manager/html for deployment (you need manager-gui role to be allowed to access it).


# 3. Functionality and API

## Endpoints
*	GET /objects (optional): Retrieve all devices Thing Descriptions(TDs) for registration to VICINITY. This functionality is optional since auto-registration will be performed, so the adapter will send the TDs to the agent at start-up.
*	GET /objects/{oid}/properties/{pid} : Get the latest value of a property of a device e.g. get set temperature of HVAC
*	PUT /objects/{oid}/properties/{pid}: Set the latest value of a property of a device e.g. set cooling or heating mode of HVAC
*	POST / objects/{oid}/actions/{aid}: Make an action e.g. open or close HVAC.
*	GET / objects/{oid}/actions/{aid}: Get status of an action e.g. HVAC is on or off.
