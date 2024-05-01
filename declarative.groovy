pipeline {
  //agent any

  // Node name agent
//  agent {
//    node { label 'workstation' }
//  }

  agent {
    label 'terraform'
  }

  parameters {
    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
  }

  environment {
    SAMPLE_URL = 'google.com'
    SSH = credentials('SSH')
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

