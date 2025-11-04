pipeline {
	
    agent any
    
    tools {
        maven 'maven' 
    }
    
    environment {
        APP_NAME = "springboot-demo"
        JAR_FILE = "target/${APP_NAME}.jar"
        DEV_SERVER = "localhost"
        DEPLOY_PATH = "/opt/apps/${APP_NAME}"
        MAVEN_HOME = "/usr/bin"
        JAVA_HOME = "/usr/lib/jvm/java-21-openjdk-amd64"
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
		stage('Deploy Dev') { 
            steps {
				echo 'Deploying to Development environment...'
				
				sh """
                    ssh user@${DEV_SERVER} 'mkdir -p ${DEPLOY_PATH}'
                    scp ${JAR_FILE} user@${DEV_SERVER}:${DEPLOY_PATH}/${APP_NAME}.jar
                    ssh user@${DEV_SERVER} 'pkill -f ${APP_NAME}.jar || true'
                    ssh user@${DEV_SERVER} 'nohup java -jar ${DEPLOY_PATH}/${APP_NAME}.jar --spring.profiles.active=dev > ${DEPLOY_PATH}/app.log 2>&1 &'
                """
				
			}
		}
    }
}