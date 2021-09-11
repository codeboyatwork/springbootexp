node('build-2004') {
	    // reference to maven
	    // ** NOTE: This 'maven-3.5.2' Maven tool must be configured in the Jenkins Global Configuration.   
	    def mvnHome = tool 'maven'
	

	    // holds reference to docker image
	    def dockerImage
	    // ip address of the docker private repository(nexus)
	    def dockerImageTag = "sbexample${env.BUILD_NUMBER}"
	    def dockerImageName
	    
	    stage('Clone Repo') { // for display purposes
	      // Get some code from a GitHub repository
	      git 'https://github.com/codeboyatwork/springbootexp.git'
	      // Get the Maven tool.
	      // ** NOTE: This 'maven-3.5.2' Maven tool must be configured
	      // **       in the global configuration.           
	      mvnHome = tool 'maven'
	    } 
	    stage('Compile') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean compile"
	    }
	    stage('Run Unit Tests') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean test -Dtest=com.experiment.demo.unittests.**.*Test*"
	    } 
	    stage('Run Integration Tests') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean test -Dtest=com.experiment.demo.integrationtests.**.*Test*"
	    }   
	    stage('Build Project') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean install -DskipTests"
	    }
			
	    stage('Build Docker Image') {
	      // build docker image
	      dockerImage = docker.build("tanmaydeshmukh1/sbexample:${env.BUILD_NUMBER}")
	    }
	   
	    stage('Check Docker Image'){
	      
	      // deploy docker image to nexus
			
	      echo "Docker Image Tag Name: ${dockerImageTag}"
		  sh "docker run --name sbexample_integration -d -p 2222:2222 -p 8080:8080 tanmaydeshmukh1/sbexample:${env.BUILD_NUMBER}"
	      sh "docker rm -f sbexample_integration"
	      dockerImageName = "sbexample:${env.BUILD_NUMBER}"
	    }
	    
	    stage('Run E2E Tests') {
	      echo "Docker Image Name ${dockerImageName}"
	      def jobHandle = build(
								job: "springboot-app-test",
								wait: true,
								parameters: [
								string(name: 'NODE_LABEL', value: env.NODE_NAME),
								string(name: 'IMAGE_NAME', value: dockerImageName),
								booleanParam(name: 'E2E_TESTS', value: true)
								]
								)
	    }
	    
	    stage('Run Acceptance Tests') {
	      echo "Docker Image Name ${dockerImageName}"
	      def jobHandle = build(
								job: "springboot-app-acceptance",
								wait: true,
								parameters: [
								string(name: 'NODE_LABEL', value: env.NODE_NAME),
								string(name: 'IMAGE_NAME', value: dockerImageName),
								booleanParam(name: 'ACCEPTANCE_TESTS', value: true)
								]
								)
	    }
	    stage('Deploy Docker Image') {
		    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
		    dockerImage.push("${env.BUILD_NUMBER}")
		    dockerImage.push("latest")
	    }
	    }
}
