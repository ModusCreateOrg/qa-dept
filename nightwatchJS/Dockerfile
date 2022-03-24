FROM node

RUN apt update && apt-get clean && apt install -y x11vnc xvfb fluxbox wmctrl wget libnss3-dev libgdk-pixbuf2.0-dev libgtk-3-dev libxss-dev vim nano

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update && apt-get -y install google-chrome-stable

COPY . /app
WORKDIR /app

RUN npm install nightwatch 
RUN npm install chromedriver

RUN useradd app -d /app \
    && mkdir -p /app \
    && chown -v -R app:app /app

USER app

EXPOSE 9515

ENTRYPOINT npm test