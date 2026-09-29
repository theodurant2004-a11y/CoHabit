
console.log("test1");
async function loadData() {
    // Dernière partie à remplacer selon les vrais noms
    const url = "http://localhost:8080/HelloWorld_war_exploded/api/hello-world";
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

function displayData(JSONdata){
    const dataZone = document.getElementById("dataZone");

    dataZone.innerHTML = "<h1>" + data.message + "</h1>";
}

document.addEventListener("DOMContentLoaded", loadData);