<div id="top"></div>

<!-- PROJECT SHIELDS -->
[![Cypress.io](https://img.shields.io/badge/tested%20with-Cypress-04C38E.svg)](https://www.cypress.io/)
![example workflow](https://github.com/ModusCreateOrg/qa-coe-experiments/actions/workflows/main.yml/badge.svg)

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <p align="center">
  <a href="https://www.cypress.io"><img src="https://cloud.githubusercontent.com/assets/1268976/20607953/d7ae489c-b24a-11e6-9cc4-91c6c74c5e88.png"/></a>
</p>

  <h3 align="center">Cypress Studio experiment</h3>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

The main goal of this experiment is to share with the community how `Cypress Studio` feature works and we're open for suggestions that improves the code as well.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* yarn
  ```sh
  npm install --global yarn
  ```

### How to run cypress tests

1. Clone the repo
   ```sh
   git clone https://github.com/ModusCreateOrg/qa-coe-experiments
   ```
3. Install NPM packages under `cypress-studio` folder
   ```sh
   cd cypress-studio
   yarn
   ```
4. You can run cypress tests in two ways:
   
  * Headless mode
  ```javascript
   npx cypress run
  ```
  or
  * Open Cypress Test Runner
  ```javascript
      npx cypress open
  ```

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- DOCKER SECTION -->
## How to run tests with docker 

### Prerequisites
Install latest docker engine on local machine following instructions  <a href="https://docs.docker.com/engine/install/">here.</a>

### How to run cypress tests locally
For executing tests without need to install cypress or nodejs on local machine run following in `cypress-studio` folder:
```sh
docker run -it -v $PWD:/e2e -w /e2e cypress/included:8.5.0
```

### Build docker image with tests
Run following in `cypress-studio`folder:
```sh
docker build -t modus/cypress-studio:latest .
```

Run tests locally:
```sh
docker run -it modus/cypress-studio:latest
```

### Push image on docker repository

For push on private repo we have to retag image to point on target docker repository, otherwise default is Dockerhub.

```sh
docker tag modus/cypress-studio:latest  path-to-private-repo.com/repo/cypress-studio:latest
```
Where `path-to-private-repo.com/repo/cypress-studio:latest`is provate target docker repository.

Credentials for target docker repository are needed for push.

Push image with:
```sh
docker push path-to-private-repo.com/repo/cypress-studio:latest
```

## Deploy on Kubernetes
### Prerequisites
Docker image is built and pushed in target repository.
Install `kubectl` tool and configure access to kubernete cluster. Installation instructions are <a href="https://kubernetes.io/docs/tasks/tools/">here.</a>
Alternativley run on local machine minicube - follow instructions <a href="https://minikube.sigs.k8s.io/docs/start/">here.</a>

### Kubernetes YAML example

Save following YAML as `modus-test-job.yaml`
```YAML
apiVersion: batch/v1
kind: Job
metadata:
  name: modus-cypress-test-job
spec:
  template:
    spec:
      containers:
      - name: modus-cypress-test-job
        image: path-to-private-repo.com/repo/cypress-studio:latest 
```

Deploy job on kubernetes:
```sh
kubectl apply -f modus-test-job.yaml
```

Find exact name of the job with:
```sh 
kubectl get pods
```

Using `kubectl logs modus-cypress-test-job-XXX` get logs/results where `modus-cypress-test-job-XXX`is the name of the job.
On development/testing cluster logs could be redirected to central logging system and results could be visible there as well. 


<!-- CONTACT -->
## Contact

Pedro Hyvo - [@pedrohyvo](https://www.linkedin.com/in/pedrohyvo/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Cypress Studio documentation](https://docs.cypress.io/guides/core-concepts/cypress-studio)

<p align="right">(<a href="#top">back to top</a>)</p>
