pipeline {
	
    agent any
    
    tools {
        maven 'maven' 
    }
    
    stages {
        stage('Build') { 
            steps {
				echo 'Building the project...' 
				sh 'mvn -DskipTests clean package' 
            }
        }
        stage('Test') { 
            steps {	
				echo 'Running tests...'
				sh 'mvn test'
			}
		}
    }
}