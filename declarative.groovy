pipeline {
  //agent any

  // Node name agent
//  agent {
//    node { label 'workstation' }
//  }

  agent {
    label 'terraform'
  }

  environment {
    SAMPLE_URL = 'google.com'
    SSH = credentialS("SSH")
  }

  stages {
    stage("one") {
      steps {
        echo "one"
        sh 'env'
      }
    }

    stage("two") {
      steps {
        echo "tw0"
      }
    }
  }

  post {
    failure {
      echo 'I will always say Hello again!'
    }
  }

}

