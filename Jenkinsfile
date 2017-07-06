pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        ansiColor(colorMapName: 'xterm') {
          dir(path: 'server') {
            sh 'java -Xmx2g -jar /opt/sbt/bin/sbt-launch.jar dataTools/clean dataToolsApp/clean dataTools/compile dataToolsApp/compile'
          }
          
        }
        
      }
    }
    stage('Test') {
      steps {
        junit(allowEmptyResults: true, testResults: '**/target/test-reports/*.xml')
        ansiColor(colorMapName: 'xterm') {
          dir(path: 'server') {
            sh 'java -Xmx2g -jar /opt/sbt/bin/sbt-launch.jar dataTools/fullTest'
          }
          
        }
        
      }
    }
    stage('Package') {
      steps {
        ansiColor(colorMapName: 'xterm') {
          dir(path: 'server') {
            sh 'java -Xmx2g -jar /opt/sbt/bin/sbt-launch.jar dataTools/package dataToolsApp/package dataToolsApp/packArchiveZip'
          }
          
        }
        
      }
    }
    stage('Publish') {
      steps {
        ansiColor(colorMapName: 'xterm') {
          dir(path: 'server') {
            archiveArtifacts 'cmwell-data-tools-app/target/*.zip'
            sh 'java -Dsbt.log.format=true -Dnexus.username=$USERNAME -Dnexus.password=$PASSWORD -jar /opt/sbt/bin/sbt-launch.jar dataTools/publish '
          }
          
        }
        
      }
    }
  }
}