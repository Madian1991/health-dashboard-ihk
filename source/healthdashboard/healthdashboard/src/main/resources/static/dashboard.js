// =============================
//  Projekte laden und rendern
// =============================
async function loadProjects() {
  const res = await fetch("/api/projects");
  const projects = await res.json();
  renderCards(projects);
}

function renderCards(projects) {
  const list = document.getElementById("project-list");
  if (!list) return;

  list.innerHTML = "";

  projects.forEach(p => {
    const name = p.name || p.projektName || "Unbekanntes Projekt";
    const progress = p.progress || p.fortschritt || 0;
    const start = p.start || p.startDatum || "-";
    const end = p.end || p.endDatum || "-";
    const status = p.status || "Unbekannt";

    const card = document.createElement("div");
    card.className = "project-card";

    card.innerHTML = `
      <h3>${escapeHtml(name)}</h3>
      <div class="project-info">
        <div class="row"><span>Schritt</span><strong>${p.step || (progress + "%")}</strong></div>
        <div class="row"><span>Projektstart:</span><strong>${start}</strong></div>
        <div class="row"><span>Deadline:</span><strong>${end}</strong></div>
      </div>
      <div class="progress-line">${renderProgress(progress)}</div>
      <p class="team-info">${p.team || ""}</p>
      <div class="actions">
        <button data-action="open">Öffnen</button>
        <button data-action="details">Details</button>
      </div>
    `;
    list.appendChild(card);
  });
}

function renderProgress(progress) {
  let filled = Math.round(progress / 20);
  let html = "";
  for (let i = 0; i < 5; i++) {
    html += `<div class="dot ${i < filled ? "done" : ""}"></div>`;
  }
  return html;
}

function escapeHtml(text) {
  const map = { "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;", "'": "&#039;" };
  return text.replace(/[&<>"']/g, m => map[m]);
}

// =============================
//  Modal Funktionen
// =============================

function openDetailsModal(title, content) {
  const modal = document.getElementById("details-modal");
  modal.style.display = "block";
  document.getElementById("modal-title").textContent = title;
  document.getElementById("modal-teamlist").innerHTML = content;
}




function closeDetails() {
  document.getElementById("details-modal").style.display = "none";
}



function openSettings() {
  const content = `
    <h4>Einstellungen</h4>
    <ul>
      <li><a href="#">Theme: Dark (fix)</a></li>
      <li><a href="#">Sprache: Deutsch</a></li>
      <li><a href="#">Login: LocalStorage (Mock)</a></li>
      <li><a href="#">Datenquelle: Mock-Daten</a></li>
      <li><a href="#">Backend: Spring Boot REST</a></li>
      <li><a href="#">Version: v0.4 (Prototype)</a></li>
      <li><a href="#">Modus: Entwicklungsmodus</a></li>
    </ul>
    <hr/>
    <h4>Theme</h4>
    <p>Das UI nutzt aktuell ein festes Dark-Theme (dashboard.css).</p>
  `;

  // أولاً نفتح المودال
  openDetailsModal("Einstellungen", content);

  // بعد فتحه، نخفي الأسطر الأربعة بعد فترة قصيرة
  setTimeout(() => {
    document.querySelectorAll("#details-modal .row, #details-modal .team-info").forEach(el => el.style.display = "none");
  }, 200);
}



// =============================
//  Sidebar Navigation
// =============================

function openAssistent() {
  const content = `
    <p>Hier kommt dein smarter Projekt-Assistent.</p>
    <hr/>
    <ul>
      <li>Hilft dir bei der Planung von Aufgaben</li>
      <li>Analysiert Fortschritt automatisch</li>
      <li>Gibt Tipps zur Effizienzsteigerung</li>
    </ul>
  `;
  openDetailsModal("Assistent", content);
}


function openDiary() {
  document.body.className = "modal-diary";
  const content = `
    <p>Hier findest du Notizen und DevLogs.</p>
    <hr/>
    <ul>
      <li>Erstelle tägliche oder wöchentliche Einträge</li>
      <li>Speichere wichtige Erkenntnisse</li>
      <li>Behalte deinen Entwicklungsfortschritt im Blick</li>
    </ul>
  `;
  openDetailsModal("Developer Diary", content);
}


function openArchive() {
  document.body.className = "modal-archiv";
  const content = `
    <p>Hier sind abgeschlossene Projekte gespeichert.</p>
    <hr/>
    <ul>
      <li>Beendete Projekte mit Status "done"</li>
      <li>Historische Daten für spätere Auswertungen</li>
      <li>Möglichkeit zur Reaktivierung alter Projekte</li>
    </ul>
  `;
  openDetailsModal("Archiv", content);
}


// =============================
//  Kartenaktionen (Öffnen / Details)
// =============================
document.addEventListener("click", (event) => {
  const target = event.target;
  if (!target.matches("button[data-action]")) return;

  const action = target.getAttribute("data-action");
  const card = target.closest(".project-card");
  const title = card.querySelector("h3").textContent;
  const progress = card.querySelector(".row strong").textContent;
  const start = card.querySelector(".row:nth-child(2) strong").textContent;
  const end = card.querySelector(".row:nth-child(3) strong").textContent;
  const status = card.querySelector(".team-info").textContent;

  if (action === "open") {
    openDetailsModal(title, `
      <p>Projekt wurde geöffnet: <b>${title}</b></p>
      <p><b>Fortschritt:</b> ${progress}</p>
      <p><b>Projektstart:</b> ${start}</p>
      <p><b>Deadline:</b> ${end}</p>
      <p><b>Status:</b> ${status}</p>
    `);
  }

  if (action === "details") {
    loadTeamAndShowDetails(title, progress, start, end, status);
  }
});

// =============================
//  Team laden und anzeigen
// =============================
async function loadTeamAndShowDetails(title, progress, start, end, status) {
  try {
    const res = await fetch("/api/team");
    const team = await res.json();

    let teamList = "<ul>";
    team.forEach(m => {
      teamList += `<li><b>${m.name}</b> — ${m.role}</li>`;
    });
    teamList += "</ul>";

    openDetailsModal(title, `
      <p><b>Projektname:</b> ${title}</p>
      <p><b>Fortschritt:</b> ${progress}</p>
      <p><b>Startdatum:</b> ${start}</p>
      <p><b>Deadline:</b> ${end}</p>
      <p><b>Status:</b> ${status}</p>
      <hr/>
      <h4>Teammitglieder</h4>
      ${teamList}
    `);
  } catch (e) {
    openDetailsModal(title, "<p>Fehler beim Laden der Teamdaten.</p>");
  }
}

// =============================
//  Status-Boxen (oben)
// =============================
document.addEventListener("DOMContentLoaded", () => {
  loadProjects();

  const aktivBox = document.getElementById("btn-aktiv");
  const risikoBox = document.getElementById("btn-risiko");
  const uberfalligBox = document.getElementById("btn-ueberfaellig");

  if (aktivBox) {
    aktivBox.style.cursor = "pointer";
    aktivBox.addEventListener("click", async () => {
      const res = await fetch("/api/projects");
      const data = await res.json();

      let msg = "<ul>";
      data.forEach(p => {
        msg += `<li><b>${p.name}</b> — Status: ${p.status}, Fortschritt: ${p.progress}%</li>`;
      });
      msg += "</ul>";

      openDetailsModal("Aktive Projekte (4)", msg);
    });
  }

  if (risikoBox) {
    risikoBox.style.cursor = "pointer";
    risikoBox.addEventListener("click", async () => {
      const res = await fetch("/api/risiken");
      const data = await res.json();

      let msg = "<ul>";
      data.forEach(r => {
        msg += `<li><b>${r.description}</b> — Schweregrad: ${r.severity}, Status: ${r.status}</li>`;
      });
      msg += "</ul>";

      openDetailsModal("Aktuelle Risiken (1)", msg);
    });
  }

  if (uberfalligBox) {
    uberfalligBox.style.cursor = "pointer";
    uberfalligBox.addEventListener("click", async () => {
      const res = await fetch("/api/deadlines");
      const data = await res.json();

      let msg = "<ul>";
      data.forEach(d => {
        msg += `<li><b>${d.milestone}</b> — Fällig am ${d.dueDate}, Status: ${d.status}</li>`;
      });
      msg += "</ul>";

      openDetailsModal("Überfällige Deadlines (1)", msg);
    });
  }
});
