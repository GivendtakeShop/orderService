INSERT INTO public.products (id, name, price) VALUES ('1', 't_shirt', 100);
INSERT INTO public.products (id, name, price) VALUES ('2', 'jean', 150);
INSERT INTO public.products (id, name, price) VALUES ('3', 'sac', 200);
INSERT INTO public.products (id, name, price) VALUES ('4', 'lifeplanner', 200);
INSERT INTO public.products (id, name, price) VALUES ('5', 'capuchon ', 250);

INSERT INTO public.orders (id, order_date, status) VALUES ('df10b1b2-b0cb-4248-a8f2-06f26772e983', '12/6/22, 1:38 PM', 'PENDING');
INSERT INTO public.orders (id, order_date, status) VALUES ('fe8916b5-9486-408c-8a72-a620f453a5b8', '12/6/22, 1:38 AM', 'PENDING');
INSERT INTO public.orders (id, order_date, status) VALUES ('5c4ada29-1f25-4afe-bd1c-b2a1817efc02', '12/3/22, 5:20 AM', 'PENDING');
INSERT INTO public.orders (id, order_date, status) VALUES ('84132c5b-24c3-478b-8fde-34cd23c774ea', '12/2/22, 1:38 AM', 'PENDING');
INSERT INTO public.orders (id, order_date, status) VALUES ('5e719638-950f-4a3a-b8bf-667f1a4ff296', '12/2/22, 1:38 AM', 'PENDING');
INSERT INTO public.orders (id, order_date, status) VALUES ('2ad2f777-4a78-401c-b061-d32604ddd68c', '12/5/22, 1:38 AM', 'DELIVERED');
INSERT INTO public.orders (id, order_date, status) VALUES ('5cedeff9-8b91-40f9-b86c-7e4adcdb0d58', '12/1/22, 1:38 AM', 'CONFIRMED');
INSERT INTO public.orders (id, order_date, status) VALUES ('9918424c-ddcf-41aa-9b29-7e61b730abf7', '12/1/22, 1:38 AM', 'DELIVERED');
INSERT INTO public.orders (id, order_date, status) VALUES ('a859a3c0-dc06-4c2d-a9af-d98ccaebafc1', '12/1/22, 1:38 AM', 'DELIVERED');
INSERT INTO public.orders (id, order_date, status) VALUES ('2ba1f9eb-1c9a-4503-b26a-c76fcdb2e2e8', '12/4/22, 1:38 AM', 'CONFIRMED');
INSERT INTO public.orders (id, order_date, status) VALUES ('2d50e7e6-845a-4178-ac98-b763fd388b70', '12/6/22, 1:38 AM', 'CONFIRMED');
INSERT INTO public.orders (id, order_date, status) VALUES ('dedb5cbe-21a2-4552-a4b1-4d1c3a1b1e17', '12/6/22, 1:38 AM', 'DELIVERED');

INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('545b6623-f84f-491e-8cab-29fa0945f0f5', 4, 'fe8916b5-9486-408c-8a72-a620f453a5b8', '3');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('e32091be-a2d5-4ddb-af92-557e733fbbba', 5, '5c4ada29-1f25-4afe-bd1c-b2a1817efc02', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('b471a146-a960-46df-8311-66d94bc1a1a2', 5, 'a859a3c0-dc06-4c2d-a9af-d98ccaebafc1', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('4a23fb7b-399a-4e9a-918d-2bd8257d66e6', 5, '84132c5b-24c3-478b-8fde-34cd23c774ea', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('f27895fb-a8ee-45c9-a767-6c01a02b06c3', 5, '5cedeff9-8b91-40f9-b86c-7e4adcdb0d58', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('a2419a28-795f-4dbc-9647-d5ad3b345a5c', 4, '2ad2f777-4a78-401c-b061-d32604ddd68c', '3');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('09b928ee-b633-4299-a872-40009e0b846b', 7, '2d50e7e6-845a-4178-ac98-b763fd388b70', '2');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('10f3b109-2ba9-432d-a9ed-86f0b86a2951', 10, 'a859a3c0-dc06-4c2d-a9af-d98ccaebafc1', '3');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('506c0a20-dae6-4aa9-b44f-5415f8562284', 7, '2ad2f777-4a78-401c-b061-d32604ddd68c', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('77cbc27d-abdf-4ebf-a166-683a0eae6af2', 7, 'dedb5cbe-21a2-4552-a4b1-4d1c3a1b1e17', '4');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('5e928c59-06f8-4b5e-a325-2fcfa69e3906', 5, 'fe8916b5-9486-408c-8a72-a620f453a5b8', '2');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('a6c0db04-1b24-4f1f-89c7-cb030263ef5b', 5, '9918424c-ddcf-41aa-9b29-7e61b730abf7', '3');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('d4f3f83d-dbda-4eb3-b247-82df6cb48adc', 8, 'dedb5cbe-21a2-4552-a4b1-4d1c3a1b1e17', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('058611e9-4035-4948-80ba-3fa3481c4ab9', 3, 'df10b1b2-b0cb-4248-a8f2-06f26772e983', '2');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('95184084-f335-48b4-a6c1-23600744fc1e', 6, '84132c5b-24c3-478b-8fde-34cd23c774ea', '4');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('1e317156-ce53-452b-a45a-6c348fcc6596', 3, '5e719638-950f-4a3a-b8bf-667f1a4ff296', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('1db29425-ee1b-4342-b36e-4b3a872a009f', 5, '2ba1f9eb-1c9a-4503-b26a-c76fcdb2e2e8', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('85e3db43-1756-4774-b4ae-f5b689b0e630', 7, '9918424c-ddcf-41aa-9b29-7e61b730abf7', '1');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('1f7f1dc9-1a55-433b-b1e2-5fd13b8a0cab', 4, '5cedeff9-8b91-40f9-b86c-7e4adcdb0d58', '2');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('96401b9b-9869-43a8-aeeb-bf03f049c8eb', 4, '5c4ada29-1f25-4afe-bd1c-b2a1817efc02', '2');
INSERT INTO public.product_orders (id, product_quantity, order_id, product_id) VALUES ('93ecb992-68cf-4c43-8032-9447c08fdd67', 4, '5e719638-950f-4a3a-b8bf-667f1a4ff296', '4');
