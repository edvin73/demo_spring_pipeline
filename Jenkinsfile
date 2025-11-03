pipeline {
	
    agent any
    
    tools {
        maven 'Maven' 
    }
    
    stages {
        stage('Build') { 
            steps {
				echo 'Building the project...' 
				sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}