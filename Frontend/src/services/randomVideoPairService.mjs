export default async function fetchRandomVideoPair()
{
    const url = "http://localhost:8080/Backend_war_exploded/getRandomVideosPair";
    const response = await fetch(url,
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
    return response.json();
}

