ALTER TABLE public.authors ADD CONSTRAINT test_unique_constraint UNIQUE (email) DEFERRABLE INITIALLY DEFERRED