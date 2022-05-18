USE `cdcs`;

CREATE TABLE `periodic_table`
(
    `id`                  BIGINT       NOT NULL AUTO_INCREMENT,
    `atomic_number`       INT          NULL DEFAULT NULL,
    `element`             VARCHAR(255) NULL DEFAULT NULL,
    `symbol`              VARCHAR(255) NULL DEFAULT NULL,
    `atomic_mass`         DOUBLE       NULL DEFAULT NULL,
    `number_of_neutrons`  INT          NULL DEFAULT NULL,
    `number_of_protons`   INT          NULL DEFAULT NULL,
    `number_of_electrons` INT          NULL DEFAULT NULL,
    `period`              INT          NULL DEFAULT NULL,
    `group`               INT          NULL DEFAULT NULL,
    `phase`               VARCHAR(255) NULL DEFAULT NULL,
    `radioactive`         BIT(1)       NULL DEFAULT NULL,
    `natural`             BIT(1)       NULL DEFAULT NULL,
    `metal`               BIT(1)       NULL DEFAULT NULL,
    `nonmetal`            BIT(1)       NULL DEFAULT NULL,
    `metalloid`           BIT(1)       NULL DEFAULT NULL,
    `type`                VARCHAR(255) NULL DEFAULT NULL,
    `atomic_radius`       DOUBLE       NULL DEFAULT NULL,
    `electronegativity`   DOUBLE       NULL DEFAULT NULL,
    `first_ionization`    DOUBLE       NULL DEFAULT NULL,
    `density`             DOUBLE       NULL DEFAULT NULL,
    `melting_point`       DOUBLE       NULL DEFAULT NULL,
    `boiling_point`       DOUBLE       NULL DEFAULT NULL,
    `number_of_isotopes`  INT          NULL DEFAULT NULL,
    `discoverer`          VARCHAR(255) NULL DEFAULT NULL,
    `year`                INT          NULL DEFAULT NULL,
    `specific_heat`       DOUBLE       NULL DEFAULT NULL,
    `number_of_shells`    INT          NULL DEFAULT NULL,
    `number_of_valence`   INT          NULL DEFAULT NULL,
    `created_timestamp`   DATETIME(6)       DEFAULT CURRENT_TIMESTAMP(6),
    `updated_timestamp`   DATETIME(6)       DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;