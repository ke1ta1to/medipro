import Image from "next/image";
import NextLink from "next/link";

export default function Hero() {
  return (
    <NextLink href="/" className="flex flex-col items-center">
      <Image
        alt="logo"
        src="/logo.svg"
        width={121}
        height={31}
        className="h-10 w-auto"
      />
    </NextLink>
  );
}
