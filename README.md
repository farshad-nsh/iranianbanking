# online iranian banking

## Architecture
This is a traditional 3 tier layer you see typically in iran, but in real international banking systems, it is better
to use DDD(domain driven design) in a microservice architecture and having the following packages only:
1-application
2-infrastructure
3-domain

## Hibernate5
I used spring data and the following object-relation mapping is done in the UML that 
i designed.
<p>@Inheritance(strategy = InheritanceType.JOINED) where superclass is account
<p>@ElementCollection since i wanted to create a strong associate(aggregate or composition) so that
when a person is removing parent, all children get removed.

<p>@Embeddable
I wanted RialTransaction and DollarTransaction to be an embeddable
since they are not entities and contain primitive types.

## bean vs service
When your application grows, it is better to put business logic inside
some classes having @Configuration since if we use @Service alot, we 
will produce a messy code that is not maintainable.







