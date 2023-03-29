SET foreign_key_checks=1;

USE peachdb;

INSERT INTO mst_user(user_name,password,family_name,first_name,family_name_kana,first_name_kana,gender) VALUES ('yamada@gmail.com','111111','山田','太郎','やまだ','たろう',0);

INSERT INTO mst_category (category_name,category_description)VALUES
('デスク環境','エンジニアの為のデスク環境アイテムのカテゴリーです'),
('健康グッズ','エンジニアの為の健康グッズのカテゴリーです'),
('新商品','エンジニアの為のデスク環境アイテムのカテゴリーです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES

('デスク','Desks','多機能デスクです。',1,7700,'/img/desc5.jpg','2023/03/05','Jungle Anaconda '),
('デスクチェア','Chairs','人間工学に基づく設計により、腰、背中、肩にかけて負荷を軽減し、長時間の作業でも楽な姿勢を保つことが出来る高機能タイプです。',1,7000,'/img/isu2.jpg','2023/03/15','Jungle Anaconda'),
('モニター','Monitors','高スペック、高機能なモニターです。',1,27000,'/img/monit.jpg','2023/03/25','Jungle Anaconda'),
('メガネ（ブルーライトカット/PC用メガネ）','Blue Light Blocking Glasses','ブルーライトをカットすることで、目への負担を軽減します。また、まぶしさをカットすることで、疲れ目を防止する効果も期待できます。',2,7000,'/img/megane.jpg','2023/03/05','Jungle Anaconda'),
('マッサージグッズ','Massage Goods','猫の肉球でもみもみする、猫による出張マッサージです。',2,5000,'/img/massage3.jpg','2023/03/15','Jungle Anaconda'),
('VRゴーグル','VR Headsets','ハンド・トラッキングが出来たり、3画面で見たりすることが出来る新商品です。',3,400000,'/img/VR3.jpg','2023/02/25','Jungle Anaconda'),
('ChatGBTロボット','ChatGBT Robots ','AIロボットがどんな質問でも答えてくれます。',3,2000000,'/img/robo.jpg','2023/03/25','Jungle Anaconda');
