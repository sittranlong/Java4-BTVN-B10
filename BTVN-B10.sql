Drop Database BTVNBuoi7;

USE BTVNBuoi7;

CREATE TABLE giang_vien (
	mssv uniqueidentifier NOT NULL DEFAULT newID(),
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	que_quan varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (mssv)
)