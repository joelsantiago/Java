# Zetcode java mysql tutorial - testdb initialization and creation
DROP TABLE IF EXISTS Books, Authors, Testing, Images;

CREATE TABLE IF NOT EXISTS Authors(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(25)) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS Books(id INT PRIMARY KEY AUTO_INCREMENT, author_id INT, title VARCHAR(100), FOREIGN KEY (author_id) REFERENCES Authors(id) ON DELETE CASCADE) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS Testing(id INT) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS Images(id INT PRIMARY KEY AUTO_INCREMENT, data MEDIUMBLOB);

INSERT INTO Authors(id, name)
VALUES
(1, "Jack London"),
(2, "Honore de Balzac"),
(3, "Lion Feuchtwanger"),
(4, "Emile Zola"),
(5, "Truman Capote");

INSERT INTO Books(id, author_id, title)
VALUES
(1, 1, "Call of the Wild"),
(2, 1, "Martin Eden"),
(3, 2, "Old Goriot"),
(4, 2, "Cousin Bette"),
(5, 3, "Jew Seuss"),
(6, 4, "Nana"),
(7, 4, "The Belly of Paris"),
(8, 5, "In Cold Blood"),
(9, 5, "Breakfast at Tifanny's");