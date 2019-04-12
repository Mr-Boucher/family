select child.first_name as child_name, mother.first_name as mother_name, mother_email_address.email_address, mother_phone_number.phone_number, father.first_name as father_name
	from family_db.person as child 
    left join family_db.person as mother on child.birth_mother_id = mother.person_id
    left join family_db.person as father on child.birth_father_id = father.person_id
    inner join family_db.email_address as mother_email_address on mother.person_id = mother_email_address.person_id
    inner join family_db.phone_number as mother_phone_number on mother.person_id = mother_phone_number.person_id
    where child.birth_father_id = (select birth_father_id from family_db.person where birth_father_id = 18);
    
    


