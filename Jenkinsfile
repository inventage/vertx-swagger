pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                setVersionSuffix()
                versiontiger('.')
                sh 'mvn -B clean deploy'
                script {
                    def d = [test: 'Default', something: 'Default', other: 'Default']
                    def props = readProperties defaults: d, file: 'target/nexus-staging/staging/117a2089d07a03.properties', text: 'other=Override'
                    build job: 'vertx-swagger/Release-Trigger', parameters: [string(name: 'stagingRepositoryId', value: props['stagingRepository.id'])]
                }
            }
        }
    }
}

/**
 * Sets the environement variable 'VERSION_SUFFIX' to yyyyMMddhhmm-${BUILD_NUMBER}
 */
def setVersionSuffix() {
    def now = sh (script: 'date -u +%Y%m%d%H%M', returnStdout: true).trim()
    env.VERSION_SUFFIX=now +"-"+ "${env.BUILD_NUMBER}"
}

def versiontiger(reactorFolder) {
	dir(reactorFolder) {
		sh 'mvn com.inventage.tools.versiontiger:versiontiger-maven-plugin:execute -B -DstatementsFile=jenkins.versiontiger'
	}
}