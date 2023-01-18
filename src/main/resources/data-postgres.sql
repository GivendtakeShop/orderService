INSERT INTO public.orders (id, order_date, status) VALUES ('3e28fa79-5b28-40bb-950a-52f84ba96435', '18/01/2023 16:55', 'DELIVERED');
INSERT INTO public.orders (id, order_date, status) VALUES ('fc2c8c06-3aad-47b6-a30a-344dd7846eed', '18/01/2023 16:25', 'DELIVERING');

INSERT INTO public.product_orders (id, product_id, product_quantity, order_id) VALUES ('4d152e84-1f76-4c6f-941e-bf7a658e45b1', '1', 2, '3e28fa79-5b28-40bb-950a-52f84ba96435');
INSERT INTO public.product_orders (id, product_id, product_quantity, order_id) VALUES ('091fcfe3-f60c-4da3-bb5d-79d666ddefb2', '2', 3, '3e28fa79-5b28-40bb-950a-52f84ba96435');
INSERT INTO public.product_orders (id, product_id, product_quantity, order_id) VALUES ('50958b77-d69e-43be-ac14-43dfdf067358', '2', 5, 'fc2c8c06-3aad-47b6-a30a-344dd7846eed');
INSERT INTO public.product_orders (id, product_id, product_quantity, order_id) VALUES ('05f5cdd0-82b1-4e6d-bf28-f71fd0b26405', '1', 1, 'fc2c8c06-3aad-47b6-a30a-344dd7846eed');
