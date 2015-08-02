#Setting up the Workspace for OpenAppEngine.

# Prerequisites #

**. Download SpringSource Tool Suite - (URL : http://www.springsource.com/landing/best-development-tool-enterprise-java?src=sts_adwords_lead )**

**. Install Maven 3 and after installation make sure that the M2\_HOME environment variable is set in the Envirobment Variables, if not set the same.**

**. Download Tomcat 7 (default Runtime Environment) for OpenAppEngine.**

# Steps #

**Check out the OpenAppEngine projects from Eclipse
  1. File -> New.
  1. In the Wizard enter "SVN" in the search input box.
  1. Select Checkout projects from SVN and click**Next**.
  1. Create a New Repository Location with URL - https://openappengine.googlecode.com/svn/trunk/
  1. Complete the wizard and all the projects would be checked out into your workspace.
  1. All projects**except**for openappengine-webapp is a Maven Project.
  1. Go to the tool bar and click on debug configurations.
  1. Click on maven build.
  1. Create a New Maven Build - Launch Configuration from the top and name it "Full Build"
  1. In the window, enter the location of your base directory as - ${workspace\_loc:/openappengine-parent} . This can be done by clicking on**Browse Workspace**and then select the project**openappengine-parent**.
  1. In the goals enter**clean install eclipse:clean eclipse:eclipse_(if running from CMD enter mvn clean install eclipse:clean eclipse:eclipse -DskipTests=true -Declipse.workspace=_

<Workspace\_Location>

