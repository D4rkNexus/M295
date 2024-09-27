INSERT INTO category_data (id, name) VALUES (1, 'Elektronik');
INSERT INTO category_data (id, name) VALUES (2, 'Kleidung');
INSERT INTO category_data (id, name) VALUES (3, 'Lebensmittel');
INSERT INTO category_data (id, name) VALUES (4, 'Möbel');
INSERT INTO category_data (id, name) VALUES (5, 'Spielzeug');

INSERT INTO category_data_seq (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count) VALUES (1, 1, 1000, 1, 1, 10, 0, 0);
INSERT INTO category_data_seq (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count) VALUES (11, 1, 1000, 1, 10, 10, 0, 0);
INSERT INTO category_data_seq (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count) VALUES (101, 1, 1000000, 1, 100, 100, 1, 1);
INSERT INTO category_data_seq (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count) VALUES (1001, 1, 10000, 1, 1, 10, 1, 10);
INSERT INTO category_data_seq (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count) VALUES (10001, 1, 100000, 1, 5, 15, 0, 0);