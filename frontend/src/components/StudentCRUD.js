import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentCRUD() {
  const [students, setStudents] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [editId, setEditId] = useState(null);

  const loadData = () => {
    axios.get("/student/getAll").then((res) => setStudents(res.data));
  };

  useEffect(() => {
    loadData();
  }, []);

  const submit = (e) => {
    e.preventDefault();

    if (editId === null) {
      axios
        .post("/student/add", { name, email })
        .then(loadData);
    } else {
      axios
        .put(`/student/${editId}`, { name, email })
        .then(loadData);
      setEditId(null);
    }

    setName("");
    setEmail("");
  };

  const edit = (s) => {
    setName(s.name);
    setEmail(s.email);
    setEditId(s.id);
  };

  const del = (id) => {
    axios.delete(`/student/${id}`).then(loadData);
  };

  return (
    <div>
      <form onSubmit={submit}>
        <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" required />
        <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" required />
        <button>{editId === null ? "Add Student" : "Update Student"}</button>
      </form>

      <ul>
        {students.map((s) => (
          <li key={s.id}>
            {s.name} ({s.email})
            <button onClick={() => edit(s)}>Edit</button>
            <button onClick={() => del(s.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default StudentCRUD;
