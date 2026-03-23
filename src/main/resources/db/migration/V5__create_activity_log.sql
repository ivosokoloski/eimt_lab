
CREATE TABLE activity_log (
                              id BIGSERIAL PRIMARY KEY,
                              book_name VARCHAR(255) NOT NULL,
                              event_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              event_type VARCHAR(50) NOT NULL
);
CREATE INDEX idx_activity_log_event_time ON activity_log(event_time);