const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const db = require('./db');

const app = express();
app.use(cors());
app.use(bodyParser.json());
app.use(express.static('public')); 

// Ruta API
app.post('/api/cartas', (req, res) => {
  const { id_carta, nombre, tipo, sub_tipo, rareza, expansion_poke } = req.body;

  const sql = `INSERT INTO cartas (id_carta, nombre, tipo, sub_tipo, rareza, expansion_poke)
               VALUES (?, ?, ?, ?, ?, ?)`;

  db.query(sql, [id_carta, nombre, tipo, sub_tipo, rareza, expansion_poke], (err, result) => {
    if (err) {
      console.error('❌ Error al insertar carta:', err.message);
      return res.status(500).send('Error al guardar la carta');
    }
    res.send('✅ Carta guardada con éxito');
  });
});

app.listen(3000, () => {
  console.log('Servidor corriendo en http://localhost:3000');
});