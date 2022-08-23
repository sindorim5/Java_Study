create database if not exists workshop;

use workshop;

drop table if exists book ;

CREATE TABLE `book` (
  `isbn` char(12) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `content` text,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into book (isbn, title, author, price, content, img)
values('111-111-1111', '자바 프로그래밍','홍길동', 30000, '자바, 객체지향부터 쓰레드까지 완벽 정복',null);

select * from book;