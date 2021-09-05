node {
	    // reference to maven
	    // ** NOTE: This 'maven-3.5.2' Maven tool must be configured in the Jenkins Global Configuration.   
	    def mvnHome = tool 'maven'
	

	    // holds reference to docker image
	    def dockerImage
	    // ip address of the docker private repository(nexus)
	 
	    def dockerImageTag = "sbexample${env.BUILD_NUMBER}"
	    
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
	      sh "'${mvnHome}/bin/mvn' clean verify -Dtest=com.experiment.demo.SimpleCalulatorTest"
	    }   
	  
	    stage('Build Project') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean install"
	    }
			
	    stage('Build Docker Image') {
	      // build docker image
	      dockerImage = docker.build("tanmaydeshmukh1/sbexample:${env.BUILD_NUMBER}")
	    }
	   
	    stage('Deploy Docker Image'){
	      
	      // deploy docker image to nexus
			
	      echo "Docker Image Tag Name: ${dockerImageTag}"
		sh "docker run --name sbexample -d -p 2222:2222 tanmaydeshmukh1/sbexample:${env.BUILD_NUMBER}"
		  
		  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
	    dockerImage.push("${env.BUILD_NUMBER}")
	    dockerImage.push("latest")
	    }
	    }
}
