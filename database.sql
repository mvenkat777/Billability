CREATE TABLE `base_excel_ibu_data` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`empl_id` VARCHAR(50) NOT NULL,
	`emp_name` VARCHAR(100) NULL DEFAULT NULL,
	`business_wait_age` VARCHAR(10) NULL DEFAULT NULL,
	`bv_status` VARCHAR(20) NULL DEFAULT NULL,
	`employee_class_category` VARCHAR(50) NULL DEFAULT NULL,
	`gender` VARCHAR(10) NULL DEFAULT NULL,
	`category_code` VARCHAR(20) NULL DEFAULT NULL,
	`employee_ibu` VARCHAR(50) NULL DEFAULT NULL,
	`htr_flag` VARCHAR(10) NULL DEFAULT NULL,
	`band` VARCHAR(10) NULL DEFAULT NULL,
	`total_experience` VARCHAR(20) NULL DEFAULT NULL,
	`current_country` VARCHAR(50) NULL DEFAULT NULL,
	`current_location_city` VARCHAR(100) NULL DEFAULT NULL,
	`onsite_offshore` VARCHAR(20) NULL DEFAULT NULL,
	`business_unit` VARCHAR(20) NULL DEFAULT NULL,
	`allocated_project_count` VARCHAR(10) NULL DEFAULT NULL,
	`project_id` VARCHAR(50) NOT NULL,
	`project_description` VARCHAR(200) NULL DEFAULT NULL,
	`project_end_date` VARCHAR(20) NULL DEFAULT NULL,
	`project_contract_type` VARCHAR(30) NULL DEFAULT NULL,
	`project_ibu` VARCHAR(25) NULL DEFAULT NULL,
	`geography` VARCHAR(20) NULL DEFAULT NULL,
	`project_maintype_descr` VARCHAR(30) NULL DEFAULT NULL,
	`project_type` VARCHAR(20) NULL DEFAULT NULL,
	`billablity_status` VARCHAR(10) NULL DEFAULT NULL,
	`non_billable_details` VARCHAR(100) NULL DEFAULT NULL,
	`customer_id` VARCHAR(30) NULL DEFAULT NULL,
	`customer_name` VARCHAR(100) NULL DEFAULT NULL,
	`supervisor_id` VARCHAR(30) NULL DEFAULT NULL,
	`supervisor_name` VARCHAR(100) NULL DEFAULT NULL,
	`pm_emplid` VARCHAR(30) NULL DEFAULT NULL,
	`pm_name` VARCHAR(100) NULL DEFAULT NULL,
	`program_manager_id` VARCHAR(30) NULL DEFAULT NULL,
	`program_manager_name` VARCHAR(100) NULL DEFAULT NULL,
	`so_id` VARCHAR(30) NULL DEFAULT NULL,
	`pjr_no` VARCHAR(30) NULL DEFAULT NULL,
	`last_working_day` VARCHAR(20) NULL DEFAULT NULL,
	`contract_number` VARCHAR(30) NULL DEFAULT NULL,
	`primary_skill_category_1` VARCHAR(50) NULL DEFAULT NULL,
	`primary_skill_category_2` VARCHAR(50) NULL DEFAULT NULL,
	`derived_project_type` VARCHAR(20) NULL DEFAULT NULL,
	`derived_po_flag` VARCHAR(10) NULL DEFAULT NULL,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `projects` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`project_code` VARCHAR(250) NOT NULL,
	`project_type` VARCHAR(100) NOT NULL,
	`project_description` VARCHAR(250) NOT NULL,
	`customer_name` VARCHAR(200) NOT NULL,
	`po_flag` TINYINT(4) NOT NULL,
	`delivery_manager` VARCHAR(200) NOT NULL DEFAULT '',
	`sales_manager` VARCHAR(200) NULL DEFAULT NULL,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `project_code` (`project_code`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `roles` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_code` VARCHAR(50) NOT NULL DEFAULT '',
	`role_name` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;
INSERT INTO `roles` (`id`, `role_code`, `role_name`) VALUES (1, 'DM', 'Delivery Manager');
INSERT INTO `roles` (`id`, `role_code`, `role_name`) VALUES (2, 'ADMIN', 'Admin');

CREATE TABLE `users` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(100) NOT NULL DEFAULT '',
	`last_name` VARCHAR(100) NOT NULL DEFAULT '',
	`email` VARCHAR(100) NOT NULL DEFAULT '',
	`password` VARCHAR(200) NOT NULL DEFAULT '',
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`role_id` INT(11) NOT NULL DEFAULT '1',
	`enabled` TINYINT(4) NOT NULL DEFAULT '1',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `email` (`email`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`, `created_at`, `updated_at`, `role_id`, `enabled`) VALUES (1, 'Mallina', 'Venkatesh', 'mv00583712@techmahindra.com', '1234', '2019-07-05 21:13:29', NULL, 2, 1);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`, `created_at`, `updated_at`, `role_id`, `enabled`) VALUES (4, 'Mahi', 'dhoni', 'mahi@dhoni.com', '1234', '2019-07-05 21:16:21', NULL, 1, 1);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`, `created_at`, `updated_at`, `role_id`, `enabled`) VALUES (5, 'Rama', 'Rao', 'rama@rao.com', '1234', '2019-07-08 17:16:06', NULL, 2, 1);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`, `created_at`, `updated_at`, `role_id`, `enabled`) VALUES (6, 'Rutherford', 'Sam', 'rutherfords@techmahindra.com', '1234', '2019-07-10 14:25:42', NULL, 1, 1);
INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`, `created_at`, `updated_at`, `role_id`, `enabled`) VALUES (7, 'Manjiri', 'Ghari', 'MG0059532@TechMahindra.com', '1234', '2019-07-30 17:17:06', NULL, 2, 1);

