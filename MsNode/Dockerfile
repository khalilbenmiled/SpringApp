FROM node:11.7.0
WORKDIR /
COPY package*.json /
RUN npm install
COPY . /
EXPOSE 3000
CMD [ "node", "index.js" ]