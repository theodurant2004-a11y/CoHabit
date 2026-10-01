const form = document.getElementById("form");

async function updateData(event) {
    event.preventDefault();

    const newString = document.getElementById("newString").value;
    const url = "http://localhost:8080/Hello_World_war_exploded/api/hello-world/1";

    try {
        const response = await fetch(url, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            },
            body: JSON.stringify({ id: 1, text: newString })
        });
        if (!response.ok) {
            throw new Error(`Statut de réponse : ${response.status}`);
        }

        const jsonResult = await response.json();
        console.log("Mise à jour réussie :", jsonResult);
    } catch (e) {
        console.error(e.message);
    }
}

async function loadData() {
    const url = "http://localhost:8080/Hello_World_war_exploded/api/hello-world/1";

    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Statut de réponse : ${response.status}`);
        }

        const result = await response.json();

        displayData(result);
    } catch (e) {
        console.error(e.message);
    }
}

function displayData(JSONData){
    const dataZone = document.getElementById("dataZone");

    dataZone.innerHTML = "<h1>" + JSONData.text + "</h1>";
}

form.addEventListener("submit", updateData);
document.addEventListener("DOMContentLoaded", loadData);