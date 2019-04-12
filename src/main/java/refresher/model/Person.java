package refresher.model;

public class Person
{
  private String firstName;
  private String mothersName;
  private String fathersName;
  private String phoneNumber;
  private String emailAddress;

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getMothersName()
  {
    return mothersName;
  }

  public void setMothersName(String mothersName)
  {
    this.mothersName = mothersName;
  }

  public String getFathersName()
  {
    return fathersName;
  }

  public void setFathersName(String fathersName)
  {
    this.fathersName = fathersName;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  @Override
  public String toString()
  {
    return "Person{" + "firstName='" + firstName + '\'' + ", mothersName='" + mothersName + '\'' + ", fathersName='" + fathersName + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", emailAddress='" + emailAddress + '\'' + '}';
  }
}
