INSERT INTO comunidad ( id, nombre, gradoConfianza, activo ) VALUES
(1, 'Comunidad A', 0, TRUE),
(2, 'Comunidad B', 1 , TRUE),
(3, 'Comunidad C', 2, TRUE),
(4, 'Comunidad D', 3 , FALSE);

INSERT INTO tipousuario(id, nombre) VALUES 
(1, 'Administrador'),
(2, 'Usuario'),
(3, 'Observador');

INSERT INTO usuario (id, nombre, contrasenia, email, telefono, activo, puntosConfianza)VALUES
(1, 'Juan Pérez', '1234', 'juan.perez@example.com', '123456789', 1, 0),
(2, 'Ana Gómez', 'pswSegura', 'ana.gomez@example.com', '987654321', 1, 0),
(3, 'Carlos Dominguez', 'password123', 'carlitos.dominguez@example.com', '555666777', 1,0);

INSERT INTO miembrocomunidad(idMiembro, comunidad_id) VALUES
(1,2),
(1,4),
(2,2);

INSERT INTO entidadprestadora (id, descripcion, email, nombre) VALUES
(1, 'Subterráneos de Buenos Aires', 'subte.ba@example.com', 'Subterráneos de Buenos Aires'),
(2, 'Ferrocarriles Argentinos', 'ferrocarriles.ar@example.com', 'Ferrocarriles Argentinos'),
(3, 'Ferrocarriles del Sur', 'ferrocarrilesDelSur.ar@example.com', 'Ferrocarriles Argentinos del Sur');

INSERT INTO establecimiento (id, nombre, entidadPrestadora_id, ubicacionGeografica) VALUES
(1,  'Estacion Caballito - Subterráneo Linea A', 1, 'Caballito, Buenos Aires, Argentina'),
(2,  'Estacion Florida - Subterráneo Linea B', 1, 'Florida, Buenos Aires, Argentina'),
(3,  'Estacion Ramos Mejia - Tren Sarmiento', 2, 'Ramos Mejia, Buenos Aires, Argentina');

INSERT INTO servicio (DTYPE, idServicio, nombre, establecimiento_id)VALUES
('Medio de Elevacion', 1, 'Escalera mecanica', 1),
('Medio de Elevacion', 2, 'Ascensor', 2),
('Servicio', 3, 'Banio', 3);

INSERT INTO incidente (id, comunidad_id, servicio_idServicio, observaciones, estado, 
horarioDeApertura, horarioDeCierre, tiempoFueraDeServicio, usuarioApertura_id, usuarioCierre_id)
VALUES
(1, 1, 1, 'Escalera mecánica fuera de servicio', 0,
 '2023-01-01 09:00:00', NULL,0, 2, NULL),
(2, 2, 2, 'Ascensor bloqueado', 0, 
'2023-01-02 14:30:00', NULL,0, 3, NULL),
(3, 1, 3, 'Baños cerrados por mantenimiento', 1, 
'2023-01-03 10:45:00','2023-01-03 13:45:00',3, 1, 2);

INSERT INTO ranking (id, detalle)
VALUES
(1, 'SegunTiempoDeCierre'),
(2, 'SegunGradoDeImpacto'),
(3, 'SegunCantIncidentes');

INSERT INTO informe (fecha, posicion, ranking, entidad_id) VALUES 
('2023-10-10 10:10:10',1,1,1),
('2023-10-10 10:10:10',2,1,2),
('2023-10-10 10:10:10',3,1,3),
('2023-10-10 10:10:10',1,2,3),
('2023-10-10 10:10:10',2,2,2),
('2023-10-10 10:10:10',3,2,1),
('2023-10-10 10:10:10',1,3,2),
('2023-10-10 10:10:10',2,3,1),
('2023-10-10 10:10:10',3,3,3);