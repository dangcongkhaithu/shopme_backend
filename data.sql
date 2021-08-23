insert into `categories` (`category_name`,`description`,`image_url`) values
('Parent Category','','');

insert into `child_categories`(`category_name`, `description`,`image_url`,`parent_id`)values
('Điện thoại','','https://salt.tikicdn.com/cache/400x400/ts/product/4f/97/ca/8cbe04489d9a2998502d24da9be5bbe5.png',1),
('Đồ gia dụng','','https://salt.tikicdn.com/cache/280x280/ts/product/15/7e/69/10b411d37f3369ee2cde91635b863609.jpg',1),
('Laptop','','https://salt.tikicdn.com/cache/400x400/ts/product/b3/70/19/422fbb6ae79d962f12e16e7340eb1722.jpg',1),
('Thời trang nam','','https://salt.tikicdn.com/cache/w444/ts/product/d3/96/07/17d330c435ce9df1a0c03e146d20e0bc.jpg',1),
('Thời trang nữ','','https://salt.tikicdn.com/cache/400x400/ts/product/09/f3/60/298cfc3d5334986c2662ff26471ca845.jpg',1),
('Giày dép','','https://salt.tikicdn.com/cache/400x400/ts/product/d3/c1/fa/de1d5572c3a5486b5c5e8281a40cc2b6.jpeg',1),
('Trang sức','','https://salt.tikicdn.com/cache/400x400/ts/product/c7/0b/0f/5ab9639198051615469c6da2615131f5.jpg',1),
('Đồng hồ','','https://salt.tikicdn.com/cache/w444/ts/product/8b/20/0a/d13d0d41b6bb33979ca63c391485de8c.jpg',1),
('Sách','','https://tiki.vn/tu-van/wp-content/uploads/2015/02/10959769_10153029732382769_4645317239916149443_n-500x500.png',1),
('Đồ chơi','','https://salt.tikicdn.com/ts/product/fd/42/95/f818f3cc20bc77062075a00ca4c32ecd.jpg',1);

-- Data dien thoai di dong
insert into `products`(`name`,`description`,`imageurl`,`price`,`category_id`) values
('Điện Thoại iPhone X 64GB - Hàng Nhập Khẩu','Hàng chính hãng mã VN/A, Mới 100%, Nguyên Seal Bộ nhớ trong: 64 GB Loại SIM: Dual SIM (nano‑SIM and eSIM) Loại màn hình: Super Retina XDR OLED, HDR10, Dolby Vision, Wide color gamut, True-tone Kích thước màn hình: 6.1 inches Độ phân giải màn hình: 1170 x 2532 pixels Hệ điều hành: iOS14','https://salt.tikicdn.com/cache/400x400/ts/product/5a/51/29/89e8b4f915671632eaa2eedf90408a2b.jpg;',25000000,1),
('Điện Thoại Xiaomi Redmi Note 10 5G (8GB-128GB)- Hàng Chính Hãng','Với bộ xử lý 5G tích hợp trên chip MediaTek Dimensity 700, Xiaomi Redmi Note 10 cho bạn trải nghiệm mạng 5G ở tốc độ tối ưu nhất. Với 5G, chiếc smartphone này chắc chắn không làm bạn thất vọng khi trải nghiệm video 4K, chơi game đồ hoạ nặng và kết nối với thế giới cực nhanh. Bạn có thể sử dụng sóng 5G trên cả hai SIM trên chiếc máy này cũng như chuyển đổi sóng giữa hai SIM hoàn toàn mượt mà.','https://salt.tikicdn.com/cache/400x400/ts/product/06/1d/34/8f530f23d7b35d0aa5a501c7fd46ba8f.jpg',49900000,1),
('S21Ultra android phone 10 Core cellphone 6800Mah','The S21Ultra 5G world-leading 32MP front camera turns your every selfie into a work of art experience greater brightness, color vibrancy, clarity and dynamic range. Even in the dimmest light, whenever you need it, your S21Ultra 5G is right there with you, capturing every moment with crystal-clear precision, Turn your selfies into masterpieces and shine in every photo.','https://salt.tikicdn.com/cache/400x400/ts/product/14/36/48/1fc8d1891247fa83d967d8c87a837dc6.jpg',1938000,1),
('iPad WiFi 128GB New 2018 - Hàng Nhập Khẩu Chính Hãng','iPad WiFi 128GB New 2018 vẫn giữ phong cách thiết kế quen thuộc như phiên bản tiền nhiệm 2017 với chất liệu nhôm nguyên khối cao cấp, các cạnh được bo cong mềm mại, tạo cảm giác cầm nắm thoải mái và chắc tay. Bên cạnh đó các chi tiết đều được gia công một cách tỉ mỉ và tinh tế, bạn sẽ phải "Wow" lên vì sức hút mãnh liệt từ vẻ đẹp bên ngoài của nó.','https://salt.tikicdn.com/cache/w1200/ts/product/a5/b1/03/5a141f8ff504b3ed8b0c80400e2a8b1a.jpg',9150000,1);

-- Đồ gia dụng
insert into `products`(`name`,`description`,`imageurl`,`price`,`category_id`) values
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2),
('','','',0,2);

-- laptop
insert into `products`(`name`,`description`,`imageurl`,`price`,`category_id`) values
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3),
('','','',0,3);

-- Thời trang nam
insert into `products`(`name`,`description`,`imageurl`,`price`,`category_id`) values
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4),
('','','',0,4);

-- Thoi trang nu
insert into `products`(`name`,`description`,`imageurl`,`price`,`category_id`) values
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5),
('','','',0,5);
