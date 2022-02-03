# Get the python 3.8 base docker image
FROM python:3.8
# Install pipenv
RUN pip install pipenv
# Copy your Pipfile and Pipfile.lock in your container
COPY Pipfile .
COPY Pipfile.lock .
# Install all the dependencies from your lock file directly into the # container
RUN pipenv install — system — deploy