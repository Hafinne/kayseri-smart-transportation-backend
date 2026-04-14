INSERT INTO stations (name, latitude, longitude)
SELECT 'Meydan', 38.7205, 35.4826
WHERE NOT EXISTS (SELECT 1 FROM stations WHERE name = 'Meydan');

INSERT INTO stations (name, latitude, longitude)
SELECT 'Talas', 38.6886, 35.5538
WHERE NOT EXISTS (SELECT 1 FROM stations WHERE name = 'Talas');

INSERT INTO stations (name, latitude, longitude)
SELECT 'Anayurt', 38.7536, 35.5278
WHERE NOT EXISTS (SELECT 1 FROM stations WHERE name = 'Anayurt');

INSERT INTO stations (name, latitude, longitude)
SELECT 'AGÜ', 38.7096, 35.5308
WHERE NOT EXISTS (SELECT 1 FROM stations WHERE name = 'AGÜ');

INSERT INTO buses (plate, capacity, current_passengers, latitude, longitude)
SELECT '38 A 1001', 80, 22, 38.7210, 35.4830
WHERE NOT EXISTS (SELECT 1 FROM buses WHERE plate = '38 A 1001');

INSERT INTO buses (plate, capacity, current_passengers, latitude, longitude)
SELECT '38 A 1002', 70, 10, 38.6888, 35.5535
WHERE NOT EXISTS (SELECT 1 FROM buses WHERE plate = '38 A 1002');

INSERT INTO buses (plate, capacity, current_passengers, latitude, longitude)
SELECT '38 A 1003', 90, 55, 38.7095, 35.5312
WHERE NOT EXISTS (SELECT 1 FROM buses WHERE plate = '38 A 1003');
