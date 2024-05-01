pipeline {
  //agent any

  // Node name agent
//  agent {
//    node { label 'workstation' }
//  }

  agent {
    label 'terraform'
  }

  stages {
    stage("one") {
      steps {
        echo "one"
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

