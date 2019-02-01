"use strict";

class APIClient {
  healthcheck() {
    const resource = new Request(`/api/healthcheck`);
    const requestData = {
      method: 'GET'
    };

    return fetch(resource, requestData);
  }

  findAll() {
    const resource = new Request(`/api/names`);
    const requestData = {
      method: 'GET'
    };

    return fetch(resource, requestData)
  }

  save(name) {
    const resource = new Request(`/api/names`);
    const requestData = {
      method: 'POST',
      body: JSON.stringify(name),
      headers: {
        'Content-Type': 'application/json'
      }
    };

    return fetch(resource, requestData)
  }
}

function checkHealth(apiClient) {
  const statusContainer = document.querySelector(".app-status-indicator");
  apiClient.healthcheck().then(response => {
    if (!response.ok) {
      statusContainer.innerText = "Not Connected";
    } else {
      statusContainer.innerText = "Connected";
    }
  }).catch(() => {
    statusContainer.innerText = "Not Connected";
  });
}

function save() {
  const apiClient = new APIClient();
  const firstName = document.getElementById("FirstName");
  const lastName = document.getElementById("LastName");
  const name = {
    firstName: firstName.value,
    lastName: lastName.value
  };
  apiClient.save(name)
    .then(response => {
      const errorContainer = document.querySelector(".error");
      if (!response.ok) {
        errorContainer.innerText = "Error Saving";
        return Promise.reject("Error Saving");
      } else {
        errorContainer.innerText = "";
        return response.json();
      }
    })
    .then(name => {
      firstName.value = "";
      lastName.value = "";
      addName(name);
    });

  return false;
}

function addName(name) {
  const dataListContainer = document.querySelector(".app-data-list");
  const element = document.createElement("li");
  element.innerText = name.hash;
  dataListContainer.append(element);
}

const apiClient = new APIClient();

setInterval(checkHealth.bind(this, apiClient), 1000);

apiClient.findAll().then(response => {
  const dataContainer = document.querySelector(".app-data");
  if (!response.ok) {
    dataContainer.append(document.createTextNode("Could not load data"));
    return Promise.reject("Could not load data");
  } else {
    return response.json();
  }
}).then(names => {
  names.forEach(name => {
    addName(name);
  });
});
