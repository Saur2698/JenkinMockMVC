
pipeline {
  
agent any 
  
  stages 
  {
  
  stage('Check out')  
    {
  steps
      {
    echo 'Checking out'
     }
       }
  stage('Package')
    {
  steps 
      {
  bat 'mvn clean package'
       }
     }
  
  stage('sonar analysis')
      {
    steps 
        {
    withSonarQubeEnv('ZensarCodeAnalysis')
          {
     bat 'mvn sonar:sonar'
          }
        }
      }
   stage('Build Docker Image') 
    {
    steps
      {
      bat 'docker build -t saur2698/test .'
        }
       }
    stage('Push Doker Image to Doker Hub')
    {
    steps 
      {
        bat 'docker login -u username -p password'
     bat 'docker push saur2698/test'
        }
       }
    
  stage('JaCoCo Report')
    {
  steps
      {
  jacoco()
     }
    }
    }
   }


