pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'sbt compile'
      }
    }
    stage('test') {
      steps {
        sh 'sbt test'
      }
    }
  }
}