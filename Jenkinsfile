pipeline {
	
    agent any
    
    tools {
        maven 'maven' 
    }
    
    environment {
        APP_NAME="springboot-demo"
        USER_NAME="edvin"
        JAR_FILE="target/${APP_NAME}.jar"
        DEV_SERVER="192.168.1.22" 
        DEPLOY_PATH="/opt/app/${APP_NAME}"
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
			
			// ssh ${USER_NAME}@${DEV_SERVER} "set +e; pkill -f springboot-demo.jar; exit 0"
            //        ssh ${USER_NAME}@${DEV_SERVER} 'nohup java -jar ${DEPLOY_PATH}/${APP_NAME}.jar --spring.profiles.active=dev > ${DEPLOY_PATH}/app.log 2>&1 &'
			
            steps {
				echo 'Deploying to Development environment...'
				
				sh """
                    ssh ${USER_NAME}@${DEV_SERVER} 'mkdir -p ${DEPLOY_PATH}'
                    scp ${JAR_FILE} ${USER_NAME}@${DEV_SERVER}:${DEPLOY_PATH}/${APP_NAME}.jar      
                    ssh ${USER_NAME}@${DEV_SERVER} "set +e; pkill -f ${APP_NAME}.jar; exit 0"
                    ssh ${USER_NAME}@${DEV_SERVER} 'nohup java -jar ${DEPLOY_PATH}/${APP_NAME}.jar --spring.profiles.active=dev > ${DEPLOY_PATH}/app.log 2>&1 &'              
                """
				
			}
		}
    }
}